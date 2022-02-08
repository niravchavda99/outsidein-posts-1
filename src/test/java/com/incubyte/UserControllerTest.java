package com.incubyte;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class UserControllerTest {

    @Inject
    @Client("/")
    HttpClient client;


    @Test
    public void get_posts_for_user_id() {
        List<Map> posts = client.toBlocking().retrieve(HttpRequest.GET("/users/2/posts"), Argument.listOf(Map.class));
        Assertions.assertFalse(posts.isEmpty());

        for (int i = 0; i < posts.size(); i++) {
            assertEquals("2", posts.get(i).get("userId"));
        }
    }

}
