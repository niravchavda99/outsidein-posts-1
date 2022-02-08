package com.incubyte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserControllerShould {
    UserController userController;
    String id;

    @Mock
    UserService service;


    @BeforeEach
    public void init() {
        userController = new UserController(service);
        id = "2";
    }

    @Test
    public void get_posts() {
        List<Post> posts = userController.getPosts(id);
        verify(service).getPosts(id);

    }
}
