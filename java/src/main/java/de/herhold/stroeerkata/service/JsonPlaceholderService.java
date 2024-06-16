package de.herhold.stroeerkata.service;

import de.herhold.stroeerkata.model.Post;
import de.herhold.stroeerkata.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class JsonPlaceholderService {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";
    private final WebClient jsonPlaceholderClient = WebClient.builder().baseUrl(BASE_URL).build();

    public Mono<User> retrieveUser(Integer id) {
        return jsonPlaceholderClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(User.class);
    }

    public Mono<List<Post>> retrievePostsForUser(Integer id) {
        return jsonPlaceholderClient.get()
                .uri("/posts?userId={id}", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }
}
