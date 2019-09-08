package wang.sunnly.kafka.multi.consumergroup;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * ConsumerThread
 * 消费者线程，消费消息
 * @author Sunnly
 * @create 2019/7/4 13:51
 */
public class ConsumerThread implements Runnable {
    private static KafkaConsumer<String,String> kafkaConsumer;
    private final String topic;

    public ConsumerThread(String brokers,String groupId,String topic){
        Properties properties = buildKafkaProperty(brokers,groupId);
        this.topic = topic;
        this.kafkaConsumer = new KafkaConsumer<String, String>(properties);
        this.kafkaConsumer.subscribe(Arrays.asList(this.topic));
    }

    private static Properties buildKafkaProperty(String brokers, String groupId){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", brokers);
        properties.put("group.id", groupId);
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("session.timeout.ms", "30000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return properties;
    }

    @Override
    public void run() {
        while (true){
            ConsumerRecords<String,String> consumerRecords = kafkaConsumer.poll(100);
            for(ConsumerRecord<String,String> item : consumerRecords){
                System.out.println("Consumer Message:"+item.value()+",Partition:"+item.partition()+"Offset:"+item.offset());
            }
        }
    }
}
