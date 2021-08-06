package com.example.amqpissue.producer;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Aiden.gong
 * @since: 2021/8/5 20:28
 */
@Component
public class MqProducer {

    private final AmqpAdmin amqpAdmin;
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public MqProducer(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
        this.amqpAdmin = amqpAdmin;
        this.amqpTemplate = amqpTemplate;
    }

    public void produceMsg() {
        ProducerMsg producerMsg = new ProducerMsg();
        producerMsg.setName("message");
        amqpTemplate.convertAndSend("test1", producerMsg);
        amqpTemplate.convertAndSend("test2", producerMsg);
    }

}
