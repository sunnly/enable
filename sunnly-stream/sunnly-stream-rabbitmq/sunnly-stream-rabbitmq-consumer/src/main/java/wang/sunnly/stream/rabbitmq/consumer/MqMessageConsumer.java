package wang.sunnly.stream.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import wang.sunnly.stream.rabbitmq.messaging.Sink;

import java.io.IOException;

/**
 * MqMessageConsumer
 *
 * @author Sunnly
 * @create 2019/7/15 15:52
 */
@EnableBinding(Sink.class)
public class MqMessageConsumer {

    @StreamListener(Sink.SUNNLYINPUT)
    public void messageInPut(Message<String> message) {
        System.err.println(" 消息接收成功：" + message.getPayload());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //第二种
    @StreamListener(Sink.SUNNLYINPUT2)
    public void receiver(Message message) throws IOException {
        Channel channel = (Channel) message.getHeaders().get(AmqpHeaders.CHANNEL);
        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        System.out.println("Msg2消息接收成功: "+message.getPayload());
//        channel.basicAck(deliveryTag,true);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @StreamListener(Sink.SUNNLYKAFKA)
    public void messageKafka(Message<String> message) {
        System.err.println(" Kafka消息接收成功：" + message.getPayload());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
