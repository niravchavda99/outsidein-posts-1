package com.incubyte;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceShould {
    PostService postService;

    @Mock
    private JsonPlaceholderGateway jsonPlaceholderGateway;

    @BeforeEach
    public void init() {
        Post post1 = new Post();
        post1.setUserId("1");
        post1.setTitle("This post contains 'qui est' here.");
        post1.setBody("This body1 has dolorem dolore in this");

        Post post2 = new Post();
        post2.setUserId("2");
        post2.setTitle("This post contains 'est qui' here.");
        post2.setBody("This body2 has dolorem dolore in this");

        Post post3 = new Post();
        post3.setUserId("3");
        post3.setTitle("This post contains 'est qui' here.");
        post3.setBody("This body has dolorem in this");

        List<Post> posts = List.of(post1, post2, post3);

        when(jsonPlaceholderGateway.getPosts()).thenReturn(posts);
        postService = new PostService(jsonPlaceholderGateway);
    }

    @Test
    public void get_posts_where_title_contains_specific_string() {
        List<Post> posts = postService.titleContains("qui est");
        verify(jsonPlaceholderGateway).getPosts();

        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts.get(0).getTitle()).isEqualTo("This post contains 'qui est' here.");
    }

    @Test
    public void get_posts_where_body_contains_certain_string() {
        List<Post> posts = postService.bodyContains("dolorem dolore");
        verify(jsonPlaceholderGateway).getPosts();

        assertThat(posts.size()).isEqualTo(2);
        assertThat(posts.get(0).getBody()).isEqualTo("This body1 has dolorem dolore in this");
        assertThat(posts.get(1).getBody()).isEqualTo("This body2 has dolorem dolore in this");
    }
}
