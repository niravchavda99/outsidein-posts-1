package com.incubyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceShould {
    @Mock
    UserGateway userGateway;

    @BeforeEach
    public void init() {
        Post post1 = new Post();
        post1.setUserId("1");
        Post post2 = new Post();
        post1.setUserId("2");

        List<Post> posts = List.of(post1, post2);

        when(userGateway.getPosts()).thenReturn(posts);
    }

    @Test
    public void get_posts_from_gateway() {
        UserService userService = new UserService(userGateway);
        List<Post> posts = userService.getPosts("2");
        verify(userGateway).getPosts();

        assertTrue(posts.size() == 1);

    }
}
