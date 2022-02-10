package com.incubyte;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/users")
public class UserController {
    @Inject
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @Get("/{userId}/posts")
    public List<Post> getPosts(int userId) {
        return service.getPosts(String.valueOf(userId));
    }

    @Get("/{username}/post")
    public List<Post> getPostsByUsername(String username) {
        return service.getPostsByUsername(username);
    }
}
