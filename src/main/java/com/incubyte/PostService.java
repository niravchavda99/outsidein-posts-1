package com.incubyte;

import jakarta.inject.Singleton;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class PostService {
    private JsonPlaceholderGateway jsonPlaceholderGateway;

    public PostService(JsonPlaceholderGateway jsonPlaceholderGateway) {
        this.jsonPlaceholderGateway = jsonPlaceholderGateway;
    }

    public List<Post> titleContains(String query) {
        return jsonPlaceholderGateway.getPosts()
                .stream()
                .filter(post -> post.getTitle().contains(query))
                .collect(Collectors.toList());
    }
}
