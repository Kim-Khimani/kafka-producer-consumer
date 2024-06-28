package com.kafka.trials.rest;

import com.kafka.trials.payload.Student;
import com.kafka.trials.producer.KafkaJsonProducer;
import com.kafka.trials.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/messages")

public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping()
  public ResponseEntity <String> sendMessage(
            @RequestBody String message)
    {
       kafkaProducer.sendMessage(message);
       return ResponseEntity.ok("Message queued successfully");
    }
    @PostMapping("/json")

    public ResponseEntity<String> sendJsonMessage(
            @RequestBody Student message
    ){
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully as Json");
    }
}
