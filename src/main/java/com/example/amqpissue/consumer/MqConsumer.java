package com.example.amqpissue.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;

/**
 * @author: Aiden.gong
 * @since: 2021/8/5 20:27
 */
@Slf4j
@Component
public class MqConsumer {

    @RabbitListener(queues = "test1")
    @Transactional(rollbackFor = Exception.class)
    public void onMassage1(Channel channel, Message message, @Payload ConsumerMsg consumerMsg, @Headers Map<String, Object> headers) throws IOException {
        log.info("onMassage1"+consumerMsg.getName());
        channel.basicAck((Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG), false);
    }

    @RabbitListener(queues = "test2")
    @Transactional(rollbackFor = Exception.class)
    public void onMassage2(Channel channel, Message message, @Payload ConsumerMsg consumerMsg) throws IOException {
        log.info("onMassage2"+consumerMsg.getName());
        channel.basicAck((Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG), false);
    }
}
