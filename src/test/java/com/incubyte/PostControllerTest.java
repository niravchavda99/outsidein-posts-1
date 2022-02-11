package com.incubyte;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@MicronautTest
public class PostControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    public void get_posts_if_title_contains_certain_string() throws UnsupportedEncodingException {
        List<Map> posts = client.toBlocking().retrieve(
                HttpRequest.GET("/posts?q=" + URLEncoder.encode("qui est", StandardCharsets.UTF_8)),
                Argument.listOf(Map.class));

        Assertions.assertFalse(posts.isEmpty());
        Map post = posts.get(0);

        Assertions.assertEquals("1", post.get("userId"));
        Assertions.assertEquals("qui est esse", post.get("title"));
    }
}
