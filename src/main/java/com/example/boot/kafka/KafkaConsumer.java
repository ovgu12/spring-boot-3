package com.example.boot.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = KafkaUtil.TEST_TOPIC)
    public void receive(ConsumerRecord<String, String> consumerRecord) {
        log.info("Received payload: '{}'", consumerRecord.value());
    }

}   