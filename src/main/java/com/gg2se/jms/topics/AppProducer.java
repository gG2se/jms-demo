package com.gg2se.jms.topics;

import com.gg2se.constant.JmsConstant;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppProducer {

    public static void main(String[] args) throws JMSException {
        // 创建connectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(JmsConstant.url);

        // 创建连接
        Connection connection = connectionFactory.createConnection();

        // 启动连接
        connection.start();

        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 创建目标
        Destination destination = session.createTopic(JmsConstant.topicName);

        // 创建生产者
        MessageProducer producer = session.createProducer(destination);

        for (int i = 0; i < 100; i++) {
            // 创建消息
            TextMessage textMessage = session.createTextMessage("topic test" + i);
            // 发布消息
            producer.send(textMessage);
            System.out.println("发送消息" + textMessage.getText());
        }
        // 关闭连接
        connection.close();
    }
}
