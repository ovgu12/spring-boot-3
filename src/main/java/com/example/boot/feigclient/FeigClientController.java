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
        log.info("Typicode {}", typicodeProperties);

        kafkaProducer.sendMessage("Hello from Typicode");

        final var restTemplate = new RestTemplate();

        var res = Optional
                .of(restTemplate.getForEntity(typicodeProperties.getHost() + "/posts", TypicodePostDTO[].class));

        res.map(HttpEntity::getBody).ifPresent(body -> System.out.println(body.length));

        return feigClientService.getPosts();
    }

}
