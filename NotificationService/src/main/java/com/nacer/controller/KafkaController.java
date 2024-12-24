package com.nacer.controller;

import com.nacer.model.Message;
import com.nacer.service.KafkaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private final KafkaService kafkaService;

    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String topic, @RequestBody Message message) {
        kafkaService.sendMessage(topic, message);
        return ResponseEntity.ok("Message envoyé avec succès au topic " + topic);
    }
}
