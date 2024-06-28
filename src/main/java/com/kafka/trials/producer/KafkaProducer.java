package com.kafka.trials.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {
     private final KafkaTemplate<String,String>kafkaTemplate;

     public void sendMessage(String msg){
         log.info(format("Sending message to tradeFinance Topic::%s",msg));
         kafkaTemplate.send("tradeFinance",msg);
     }
}
