package wang.sunnly.kafka.multi.consumerthread;

import wang.sunnly.kafka.multi.ProducerThread;

/**
 * ConsumerThreadMain
 *
 * @author Sunnly
 * @create 2019/7/4 13:58
 */
public class ConsumerThreadMain {
    public static void main(String[] args){
        String brokers = "192.168.1.249:9092";
        String groupId = "group01";
        String topic = "HelloWorld";
        int consumerNumber = 3;


        Thread producerThread = new Thread(new ProducerThread(brokers,topic));
        producerThread.start();

        ConsumerThread consumerThread = new ConsumerThread(brokers,groupId,topic);
        consumerThread.start(3);

    }
}
