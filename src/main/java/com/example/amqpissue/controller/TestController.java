package com.example.amqpissue.controller;

import com.example.amqpissue.producer.MqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Aiden.gong
 * @since: 2021/8/5 20:33
 */
@RestController
public class TestController {

    @Autowired
    private MqProducer mqProducer;

    @GetMapping("/sendMsg")
    private ResponseEntity<String> sendMsg() {
        mqProducer.produceMsg();
        return ResponseEntity.ok("send success!");
    }
}
