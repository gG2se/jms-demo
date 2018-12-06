package com.gg2se.jms.queues;

import com.gg2se.constant.JmsConstant;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppConsumer {

    public static void main(String[] args) throws JMSException {
        // 创建connectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(JmsConstant.url);

        /* 创建连接 */
        Connection connection = connectionFactory.createConnection();

        // 启动连接
        connection.start();

        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 创建目标
        Destination destination = session.createQueue(JmsConstant.queueName);

        // 创建消费者
        MessageConsumer consumer = session.createConsumer(destination);

        // 创建一个监听器
        consumer.setMessageListener(message -> {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println(textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });
    }
}
