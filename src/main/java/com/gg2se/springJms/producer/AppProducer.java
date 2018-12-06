package com.gg2se.springJms.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProducer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service = context.getBean(ProducerService.class);

        for (int i = 0; i < 100; i++) {
            service.sendMessage("spring queue test" + i);
        }
        context.close();
    }
}
