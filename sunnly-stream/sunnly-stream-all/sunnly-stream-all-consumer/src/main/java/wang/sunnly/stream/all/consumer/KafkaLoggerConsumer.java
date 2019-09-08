package wang.sunnly.stream.all.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import wang.sunnly.stream.all.sink.KafkaLoggerSink;

/**
 * KafkaLoggerConsumer
 *
 * @author Sunnly
 * @create 2019/7/17 0017 19:35
 */
@EnableBinding(KafkaLoggerSink.class)
public class KafkaLoggerConsumer {

    @StreamListener(KafkaLoggerSink.KAFKA_LOGGER_DEBUG)
    public void kafkaLoggerDebug(Message<String> message) {
        System.err.println("【KAFKA_LOGGER_DEBUG】：" + message.getPayload());
    }

    @StreamListener(KafkaLoggerSink.KAFKA_LOGGER_ERROR)
    public void kafkaLoggerError(Message<String> message) {
        System.err.println("【KAFKA_LOGGER_ERROR】：" + message.getPayload());
    }
    @StreamListener(KafkaLoggerSink.KAFKA_TEST_DEBUG)
    public void kafkaTestDebug(Message<String> message) {
        System.err.println("【KAFKA_TEST_DEBUG】：" + message.getPayload());
    }

}
