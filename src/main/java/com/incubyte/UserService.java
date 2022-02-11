package com.incubyte;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class UserService {
    @Inject
    private JsonPlaceholderGateway jsonPlaceholderGateway;

    public UserService(JsonPlaceholderGateway jsonPlaceholderGateway) {
        this.jsonPlaceholderGateway = jsonPlaceholderGateway;
    }

    public List<Post> getPosts(String id) {
        return jsonPlaceholderGateway.getPosts()
                .stream()
                .filter(post -> id.equals(post.getUserId()))
                .collect(Collectors.toList());
    }

    public List<Post> getPostsByUsername(String username) {
        User user = getUserByUsername(username);
        return jsonPlaceholderGateway.getPosts().stream().filter(post -> post.getUserId().equals(user.getId())).collect(Collectors.toList());
    }

    public User getUserByUsername(String username) {
        List<User> users = jsonPlaceholderGateway.getUsers();

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return new User();
    }
}
