package com.example.boot.cloud;

import com.example.boot.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

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
    @RequestMapping("/feig")
    public List<TypicodePost> feig() {
        return feigClientService.getPosts();
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/rtl")
    public List<TypicodePost> rtl() {
        var result = new RestTemplate().getForEntity(typicodeProperties.getHost() + "/posts", TypicodePost[].class);
        if (result.getBody() == null) {
            return Collections.emptyList();
        }
        return List.of(result.getBody());
    }

    @GetMapping()
    @RequestMapping("/kafka")
    public void sendMessage() {
        kafkaProducer.sendMessage("Kafka says hello");
    }

}
