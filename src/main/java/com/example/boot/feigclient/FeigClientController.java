package com.example.boot.feigclient;

import com.example.boot.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/cloud")
@Slf4j
public class FeigClientController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private TypicodeProperties typicodeProperties;

    @Autowired
    private FeigClientService feigClientService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TypicodePostDTO> index() {
        kafkaProducer.sendMessage("Hello from Typicode");

        Optional
                .of(new RestTemplate().getForEntity(typicodeProperties.getHost() + "/posts", TypicodePostDTO[].class))
                .map(HttpEntity::getBody)
                .ifPresent(body ->
                        System.out.println(
                                Stream.of(body)
                                        .map(TypicodePostDTO::getId)
                                        .collect(Collectors.toList())
                        ));

        return feigClientService.getPosts();
    }

}
