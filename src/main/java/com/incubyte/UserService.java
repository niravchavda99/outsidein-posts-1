package com.incubyte;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Singleton
public class UserService {
    @Inject
    private UserGateway userGateway;

    public UserService(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public List<Post> getPosts(String id) {
        return userGateway.getPosts()
                .stream()
                .filter(post -> post.getUserId().equals(id))
                .collect(Collectors.toList());
    }
}
