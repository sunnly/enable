package wang.sunnly.stream.all.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import wang.sunnly.stream.all.source.KafkaLoggerSource;

/**
 * RabbitMessageProcessor
 *
 * @author Sunnly
 * @create 2019/7/17 10:15
 */
@EnableBinding(KafkaLoggerSource.class)
public class KafkaMessageProcessor {

    @Autowired
    private KafkaLoggerSource kafkaLoggerSource;

    public boolean debug(String message){
        return kafkaLoggerSource.kafkaLoggerDebug()
                .send(MessageBuilder.withPayload(message).build());
    }

    public boolean error(String message){
        return kafkaLoggerSource.kafkaLoggerError()
                .send(MessageBuilder.withPayload(message).build());
    }

    public boolean test(String message){
        return kafkaLoggerSource.kafkaTestDebug()
                .send(MessageBuilder.withPayload(message).build());
    }

//    @Bean
//    @InboundChannelAdapter(value = KafkaLoggerSource.KAFKA_LOGGER_DEBUG,
//            poller = @Poller(fixedDelay = "10", maxMessagesPerPoll = "1"))
////    @Transformer(inputChannel = KafkaLoggerSource.KAFKA_LOGGER_DEBUG,
////            outputChannel = KafkaLoggerSource.KAFKA_LOGGER_ERROR)
//
////    @ServiceActivator
//    public MessageSource<String> timerMessageSource() {
//        return () -> new GenericMessage<>("Hello Spring Cloud Stream");
//    }


}
