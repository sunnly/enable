package wang.sunnly.kafka.multi;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * ProducerThread
 *生产者线程，发送消息到Broker
 * @author Sunnly
 * @create 2019/7/4 13:50
 */
public class ProducerThread implements Runnable {
    private final Producer<String,String> kafkaProducer;
    private final String topic;

    public ProducerThread(String brokers,String topic){
        Properties properties = buildKafkaProperty(brokers);
        this.topic = topic;
        this.kafkaProducer = new KafkaProducer<String,String>(properties);

    }

    private static Properties buildKafkaProperty(String brokers){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", brokers);
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return properties;
    }

    @Override
    public void run() {
        System.out.println("start sending message to kafka");
        int i = 0;
        while (true){
            String sendMsg = "Producer message number:"+String.valueOf(++i);
            kafkaProducer.send(new ProducerRecord<String, String>(topic,sendMsg),new Callback(){

                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if(e != null){
                        e.printStackTrace();
                    }
                    System.out.println("Producer Message: Partition:"+recordMetadata.partition()+",Offset:"+recordMetadata.offset());
                }
            });
            // thread sleep 3 seconds every time
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end sending message to kafka");
        }
    }
}
