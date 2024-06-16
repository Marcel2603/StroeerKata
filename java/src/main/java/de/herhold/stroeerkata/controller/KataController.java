package de.herhold.stroeerkata.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.herhold.stroeerkata.model.Post;
import de.herhold.stroeerkata.model.User;
import de.herhold.stroeerkata.model.api.UserInformation;
import de.herhold.stroeerkata.service.JsonPlaceholderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class KataController {
    private final JsonPlaceholderService jsonPlaceHolderService;
    private final ObjectMapper mapper = new ObjectMapper();

    public KataController(JsonPlaceholderService jsonPlaceHolderService) {
        this.jsonPlaceHolderService = jsonPlaceHolderService;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInformation> getUserInformation() {
        Mono<User> userMono = jsonPlaceHolderService.retrieveUser();
        Mono<List<Post>> postsMono = jsonPlaceHolderService.retrievePostsForUser();
        UserInformation userInformation = Mono.zip(userMono, postsMono)
                .map(responses -> new UserInformation(responses.getT1(), responses.getT2()))
                .block();

        return ResponseEntity.ok(userInformation);
    }
}
