package com.gg2se.springJms.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConsumer {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("consumer.xml");
    }
}
