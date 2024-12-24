package com.nacer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic commandesTopic() {
        return new NewTopic("commandes", 1, (short) 1);
    }
}
