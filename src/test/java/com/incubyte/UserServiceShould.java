package com.incubyte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceShould {
    @Mock
    UserGateway userGateway;

    UserService userService;

    @BeforeEach

    public void init() {
        Post post1 = new Post();
        post1.setUserId("1");
        Post post2 = new Post();
        post2.setUserId("2");
        Post post3 = new Post();
        post3.setUserId("3");

        User user1 = new User();
        user1.setId("1");
        user1.setUsername("Bret");
        User user2 = new User();
        user2.setId("3");
        user2.setUsername("Samantha");

        userService = new UserService(userGateway);

        List<Post> posts = List.of(post1, post2, post3);
        List<User> users = List.of(user1, user2);

        when(userGateway.getPosts()).thenReturn(posts);
        when(userGateway.getUsers()).thenReturn(users);
    }

    @Test
    public void get_posts_from_gateway() {
        List<Post> posts = userService.getPosts("2");
        verify(userGateway).getPosts();

        assertEquals(1, posts.size());

    }

    @Test
    public void get_user_by_username() {
        User user = userService.getUserByUsername("Samantha");
        verify(userGateway).getUsers();

        assertEquals("3", user.getId());
        assertEquals("Samantha", user.getUsername());
    }

    @Test
    public void get_posts_by_username() {
        List<Post> postsByUsername = userService.getPostsByUsername("Samantha");
        verify(userGateway).getUsers();

        for (Post post : postsByUsername) {
            assertEquals("3", post.getUserId());
        }
    }
}
