package wang.sunnly.kafka.multi.consumergroup;

import wang.sunnly.kafka.multi.ProducerThread;

/**
 * ConsumerGroupMain
 *
 * @author Sunnly
 * @create 2019/7/4 13:54
 */
public class ConsumerGroupMain {
    public static void main(String[] args){
        String brokers = "Server2:9092";
        String groupId = "group01";
        String topic = "HelloWorld";
        int consumerNumber = 3;

        Thread producerThread = new Thread(new ProducerThread(brokers,topic));
        producerThread.start();

        ConsumerGroup consumerGroup = new ConsumerGroup(brokers,groupId,topic,consumerNumber);
        consumerGroup.start();
    }
}
