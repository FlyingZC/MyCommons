package com.zc.z12rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class Consumer {
    public static void main(String[] args) throws MQClientException {
        /*
         * Instantiate with specified Consumer group name.
         */
        DefaultMQPushConsumer Consumer = new DefaultMQPushConsumer("please rename to unique group name");

        /*
         * Specify name server addresses.
        Consumer.setNamesrvAddr("192.168.249.47:9876");
        /*
         * Specify where to start in case the specified Consumer group is a brand new one.
         */
        Consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //Consumer.setMessageModel(MessageModel.BROADCASTING);
        /*
         * Subscribe one more more Topics to consume.
         */
        Consumer.subscribe("TopicTest", "*");
        /*
         *  Register callback to execute on arrival of Messages fetched from brokers.
         */
        Consumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.printf(Thread.currentThread().getName() + " Receive New Messages: " + msgs + "%n");
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        /*
         *  Launch the Consumer instance.
         */
        Consumer.start();
    }
}
