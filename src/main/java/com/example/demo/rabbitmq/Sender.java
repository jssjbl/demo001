package com.example.demo.rabbitmq;

import lombok.Data;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 *
 */
@Component
public class Sender {
    /**
     * 发送消息的方法
     */
//    @Autowired
//    private AmqpTemplate amqpTemplate;
//
//    public void send(String string){
//    //向消息队列发送消息
//        //第一个参数表示队列的名称，
//        //第二个参数
//        amqpTemplate.convertAndSend("hello-queue",string);
//    }
}
