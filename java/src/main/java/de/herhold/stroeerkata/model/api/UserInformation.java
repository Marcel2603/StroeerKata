package de.herhold.stroeerkata.model.api;

import de.herhold.stroeerkata.model.Post;
import de.herhold.stroeerkata.model.User;

import java.util.List;

public record UserInformation(
        User user,
        List<Post> posts
) {
}
