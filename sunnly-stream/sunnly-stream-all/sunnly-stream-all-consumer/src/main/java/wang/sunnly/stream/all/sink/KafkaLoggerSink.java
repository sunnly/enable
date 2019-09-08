package wang.sunnly.stream.all.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * kafkaLoggerSink
 *
 * @author Sunnly
 * @create 2019/7/17 0017 19:31
 */
public interface KafkaLoggerSink {

    public String KAFKA_LOGGER_DEBUG = "kafkaLoggerDebug";
    public String KAFKA_LOGGER_ERROR = "kafkaLoggerError";
    public String KAFKA_TEST_DEBUG = "kafkaTestDebug";

    @Input(KAFKA_LOGGER_DEBUG)
    SubscribableChannel kafkaLoggerDebug();

    @Input(KAFKA_LOGGER_ERROR)
    SubscribableChannel kafkaLoggerError();

    @Input(KAFKA_TEST_DEBUG)
    SubscribableChannel kafkaTestDebug();
}
