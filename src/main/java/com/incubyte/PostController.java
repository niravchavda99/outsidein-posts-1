package com.incubyte;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/posts")
public class PostController {

    @Inject
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Get
    public List<Post> titleContains(@QueryValue String q) {
        return postService.titleContains(q);
    }
}
