package wang.sunnly.stream.rabbitmq.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import wang.sunnly.stream.rabbitmq.messaging.Source;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Processor
 *
 * @author Sunnly
 * @create 2019/7/15 15:23
 */

@EnableBinding(Source.class)
public class MyMessageProcessor {

    @Resource(name = Source.SUNNLYOUTPUT)
    private MessageChannel sendChannel;

    public boolean sendMsg(String msg) {
        return sendChannel.send(MessageBuilder.withPayload(msg).build());
    }


    // 第二种方式

    @Autowired
    private Source source;

    public boolean sendMsg2(String message,Map<String ,Object > headers){
        return source.sunnlyOutput2()
                .send(MessageBuilder
                        .createMessage(message, new MessageHeaders(headers)));
    }

//    @InboundChannelAdapter(value = Source.SUNNLYOUTPUT2,
//            poller = @Poller(fixedDelay = "2000", maxMessagesPerPoll = "1"))
//    public boolean sendMsg3(String message){
//        return source.sunnlyOutput2().send(new GenericMessage<>(message));
//    }

    @Resource(name = Source.SUNNLYKAFKA)
    private MessageChannel sendKafkaChannel;

    public boolean sendKafkaMsg(String msg) {
        return sendKafkaChannel.send(MessageBuilder.withPayload(msg).build());
    }
}
