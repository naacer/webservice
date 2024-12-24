package com.nacer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommandeProducer {

    private static final String TOPIC = "commandes-topic"; // Nom du topic
    private final KafkaTemplate<String, String> kafkaTemplate;

    public CommandeProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void envoyerMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Message envoyé au topic Kafka : " + message);
    }
}
