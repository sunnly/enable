package wang.sunnly.stream.all.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import wang.sunnly.stream.all.source.RabbitLoggerSource;

/**
 * RabbitMessageProcessor
 *
 * @author Sunnly
 * @create 2019/7/17 10:15
 */
@EnableBinding(RabbitLoggerSource.class)
public class RabbitMessageProcessor {

    @Autowired
    private RabbitLoggerSource rabbitLoggerSource;

    public boolean debug(String message){
        return rabbitLoggerSource.rabbitLoggerDebug()
                .send(MessageBuilder.withPayload(message).build());
    }

    public boolean error(String message){
        return rabbitLoggerSource.rabbitLoggerError()
                .send(MessageBuilder.withPayload(message).build());
    }

    public boolean test(String message){
        return rabbitLoggerSource.rabbitTestDebug()
                .send(MessageBuilder.withPayload(message).build());
    }

}
