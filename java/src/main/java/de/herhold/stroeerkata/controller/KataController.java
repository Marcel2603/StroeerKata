package de.herhold.stroeerkata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.herhold.stroeerkata.service.JsonPlaceholderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class KataController {
    private final JsonPlaceholderService jsonPlaceHolderService;
    private final ObjectMapper mapper = new ObjectMapper();

    public KataController(JsonPlaceholderService jsonPlaceHolderService) {
        this.jsonPlaceHolderService = jsonPlaceHolderService;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUserInformation() {
        Mono<String> userMono = jsonPlaceHolderService.retrieveUser().delayElement(Duration.ofSeconds(2));
        Mono<String> postsMono = jsonPlaceHolderService.retrievePostsForUser().delayElement(Duration.ofSeconds(3));
        Mono<String> response = Mono.zip(userMono, postsMono)
                .handle((responses, sink) -> {
                    try {
                        Map<String, Object> userJsonMap = mapper.readValue(responses.getT1(), new TypeReference<>() {
                        });
                        Map<String, Object> data = new HashMap<>(userJsonMap);
                        data.put("post", mapper.readValue(responses.getT2(), new TypeReference<List<Map<String, Object>>>() {
                        }));
                        sink.next(mapper.writeValueAsString(data));
                    } catch (JsonProcessingException e) {
                        sink.error(new RuntimeException(e));
                    }
                });

        return ResponseEntity.ok(response.block());
    }
}
