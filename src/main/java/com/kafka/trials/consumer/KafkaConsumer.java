package com.kafka.trials.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics="tradeFinance",groupId ="myGroup")
    public void consumeMsg(String msg){
        log.info(String.format("Consuming the message from TradeFinance Topic:: %s",msg));
    }

}
