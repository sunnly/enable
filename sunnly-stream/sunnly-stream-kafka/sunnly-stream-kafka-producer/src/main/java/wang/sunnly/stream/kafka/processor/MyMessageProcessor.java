package wang.sunnly.stream.kafka.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import wang.sunnly.stream.kafka.messaging.Source;

import javax.annotation.Resource;

/**
 * Processor
 *
 * @author Sunnly
 * @create 2019/7/15 15:23
 */

@EnableBinding(Source.class)
public class MyMessageProcessor {

    @Autowired
    @Resource(name = Source.SUNNLYOUTPUT)
    private MessageChannel sendChannel;

    public boolean sendMsg(String msg) {
//        return sendChannel.send(MessageBuilder.withPayload(msg).build());
        return sendChannel.send(MessageBuilder.withPayload(msg).build());
    }

}
