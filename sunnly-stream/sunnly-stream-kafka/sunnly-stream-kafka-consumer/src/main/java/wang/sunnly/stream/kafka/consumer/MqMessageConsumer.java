package wang.sunnly.stream.kafka.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import wang.sunnly.stream.kafka.messaging.Sink;

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
    }
}
