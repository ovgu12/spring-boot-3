package com.example.boot.cloud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeigClientService {

    private final FeigClient feigClient;

    public List<TypicodePost> getPosts() {
        return feigClient.getPosts();
    }

    public TypicodePost getPostById(Long postId) {
        return feigClient.getPostById(postId);
    }

}
