package de.herhold.stroeerkata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.herhold.stroeerkata.service.JsonPlaceholderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> getUserInformation() throws JsonProcessingException {
        String user = jsonPlaceHolderService.retrieveUser();
        String posts = jsonPlaceHolderService.retrievePostsForUser();
        Map<String, Object> userJsonMap = mapper.readValue(user, new TypeReference<>() {
        });
        Map<String, Object> merged = new HashMap<>(userJsonMap);
        merged.put("posts", mapper.readValue(posts, new TypeReference<List<Map<String, Object>>>() {
        }));

        return ResponseEntity.ok(mapper.writeValueAsString(merged));
    }
}
