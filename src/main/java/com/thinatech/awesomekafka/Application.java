package com.thinatech.awesomekafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class Application {

    @Value("${kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public Application(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void write(byte[] data) {
        kafkaTemplate.send(topic, data);
    }

    void write(String key, byte[] data) {
        kafkaTemplate.send(topic, key, data);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
