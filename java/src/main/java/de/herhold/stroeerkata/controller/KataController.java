package de.herhold.stroeerkata.controller;

import de.herhold.stroeerkata.api.handler.UserApi;
import de.herhold.stroeerkata.api.model.UserInformation;
import de.herhold.stroeerkata.helper.UserInformationMapper;
import de.herhold.stroeerkata.model.Post;
import de.herhold.stroeerkata.model.User;
import de.herhold.stroeerkata.service.JsonPlaceholderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class KataController implements UserApi {
    private final JsonPlaceholderService jsonPlaceHolderService;

    public KataController(JsonPlaceholderService jsonPlaceHolderService) {
        this.jsonPlaceHolderService = jsonPlaceHolderService;
    }

    @Override
    public ResponseEntity<UserInformation> getUserInformation(Integer id) {
        UserInformation userInformation = retrieveUserInformation();

        return ResponseEntity.ok(userInformation);
    }

    private UserInformation retrieveUserInformation() {
        Mono<User> userMono = jsonPlaceHolderService.retrieveUser();
        Mono<List<Post>> postsMono = jsonPlaceHolderService.retrievePostsForUser();
        return Mono.zip(userMono, postsMono)
                .map(responses -> UserInformationMapper.INSTANCE.mapUserAndPost(responses.getT1(), responses.getT2()))
                .block();
    }
}
