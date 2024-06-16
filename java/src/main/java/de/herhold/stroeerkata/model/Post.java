package de.herhold.stroeerkata.model;

public record Post(
        int userId,
        int id,
        String title,
        String body
) {
}
