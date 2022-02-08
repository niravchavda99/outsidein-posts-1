package com.incubyte;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;

@Controller("/users")
public class UserController {
    @Inject
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @Get("/{userId}/posts")
    public List<Post> getPosts(String userId) {
        return service.getPosts(userId);
    }
}
