package de.herhold.stroeerkata.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class JsonPlaceholderService {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";
    private final WebClient jsonPlaceholderClient = WebClient.builder().baseUrl(BASE_URL).build();

    public String retrieveUser() {
        return jsonPlaceholderClient.get()
                .uri("/users/1")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String retrievePostsForUser() {
        return jsonPlaceholderClient.get()
                .uri("/posts?userId=1")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}