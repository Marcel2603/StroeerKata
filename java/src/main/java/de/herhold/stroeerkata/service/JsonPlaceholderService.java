package de.herhold.stroeerkata.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class JsonPlaceholderService {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";
    private final WebClient jsonPlaceholderClient = WebClient.builder().baseUrl(BASE_URL).build();

    public Mono<String> retrieveUser() {
        return jsonPlaceholderClient.get()
                .uri("/users/1")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> retrievePostsForUser() {
        return jsonPlaceholderClient.get()
                .uri("/posts?userId=1")
                .retrieve()
                .bodyToMono(String.class);
    }
}
