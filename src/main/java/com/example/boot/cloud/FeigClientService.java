package com.example.boot.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeigClientService {

    @Autowired
    private FeigClient feigClient;

    public List<TypicodePost> getPosts() {
        return feigClient.getPosts();
    }

    public TypicodePost getPostById(Long postId) {
        return feigClient.getPostById(postId);
    }

}
