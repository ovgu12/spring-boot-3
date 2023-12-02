package com.example.boot.feigclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface FeigClient {

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<TypicodePostDTO> getPosts();

    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    TypicodePostDTO getPostById(@PathVariable("postId") Long postId);

}
