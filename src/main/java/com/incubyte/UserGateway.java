package com.incubyte;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class UserGateway {
    @Inject
    @Client("https://jsonplaceholder.typicode.com/")
    HttpClient client;

    public List<Post> getPosts() {
        List<Post> posts = client.toBlocking().retrieve(HttpRequest.GET("/posts"), Argument.listOf(Post.class));
        return posts;
    }


    public List<User> getUsers() {
        List<User> users = client.toBlocking().retrieve(HttpRequest.GET("/users"), Argument.listOf(User.class));
        return users;
    }
}
