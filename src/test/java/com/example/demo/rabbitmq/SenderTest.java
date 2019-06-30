package com.example.demo.rabbitmq;

import com.example.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import thread.ThreadA;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class SenderTest {
//    @Autowired
//    private Sender sender;
//
//    @Test
//    public void test1() throws InterruptedException {
//        while (true){
//            Thread.sleep(1000);
//            sender.send("杨逸飞");
//        }
//
//    }
}