package com.incubyte;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PostControllerShould {

    @Mock
    private PostService postService;

    @Test
    public void get_posts_where_title_does_contain_some_string() {
        PostController postController = new PostController(postService);
        List<Post> posts = postController.titleContains("qui est");
        verify(postService).titleContains("qui est");
    }

    @Test
    public void get_posts_where_body_contains_certain_string() {
        PostController postController = new PostController(postService);
        List<Post> posts = postController.bodyContains("dolorem dolore");
        verify(postService).bodyContains("dolorem dolore");
    }
}
