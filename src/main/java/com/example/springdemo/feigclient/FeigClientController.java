package com.example.springdemo.feigclient;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springdemo.config.TypicodeProperties;
import com.example.springdemo.kafka.KafkaProducer;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/dummy")
@Slf4j
public class FeigClientController {
    
    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private TypicodeProperties typicodeProperties;

    @Autowired
    private FeigClientService feigClientService;

    @GetMapping(value = "/index", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TypicodePostDTO> index() {
        log.info("Typicode {}", typicodeProperties);
        kafkaProducer.sendMessage("List Books");

        final RestTemplate restTemplate = new RestTemplate();

        var res = Optional.of(restTemplate.getForEntity(typicodeProperties.getHost() + "/posts",  TypicodePostDTO[].class));
        res.map(r -> r.getBody()).ifPresent(body -> System.out.println(body.length));

        return feigClientService.getPosts();
    }

}
