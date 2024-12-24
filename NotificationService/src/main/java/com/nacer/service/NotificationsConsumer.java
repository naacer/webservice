package com.nacer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationsConsumer {

    @KafkaListener(topics = "commandes-topic", groupId = "group_id")
    public void consommerMessage(String message) {
        System.out.println("Message reçu de Kafka : " + message);
        // Logique pour envoyer une notification ou traiter le message
    }
}
