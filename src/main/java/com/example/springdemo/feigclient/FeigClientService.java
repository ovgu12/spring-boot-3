package com.example.springdemo.feigclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeigClientService  {

    @Autowired
    private FeigClient feigClient;

    public List<TypicodePostDTO> getPosts() {
        return feigClient.getPosts();
    }

    public TypicodePostDTO getPostById(Long postId) {
        return feigClient.getPostById(postId);
    }
    
}
