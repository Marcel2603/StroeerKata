package de.herhold.stroeerkata.controller;

import de.herhold.stroeerkata.service.JsonPlaceHolderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KataController {
    private final JsonPlaceHolderService jsonPlaceHolderService;

    public KataController(JsonPlaceHolderService jsonPlaceHolderService) {
        this.jsonPlaceHolderService = jsonPlaceHolderService;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUserInformation() {
        return ResponseEntity.ok(jsonPlaceHolderService.retrieveUser());
    }
}
