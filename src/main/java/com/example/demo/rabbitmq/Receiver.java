package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息的接受者
 */
@Component
public class Receiver {
    //接受消息的方法，采用消息队列监听机制
//    @RabbitListener(queues = {"hello-queue"})
//    public void process(String string){
//        System.out.println("receiver:"+string);
//    }
}
