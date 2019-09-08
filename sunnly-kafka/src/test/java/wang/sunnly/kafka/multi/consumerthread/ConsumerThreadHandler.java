package wang.sunnly.kafka.multi.consumerthread;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * ConsumerThreadHandler
 * 处理发送到消费者的消息
 * @author Sunnly
 * @create 2019/7/4 13:56
 */
public class ConsumerThreadHandler  implements Runnable {
    private ConsumerRecord consumerRecord;

    public ConsumerThreadHandler(ConsumerRecord consumerRecord){
        this.consumerRecord = consumerRecord;
    }

    @Override
    public void run() {
        System.out.println("Consumer Message:"+consumerRecord.value()+",Partition:"+consumerRecord.partition()+"Offset:"+consumerRecord.offset());
    }
}