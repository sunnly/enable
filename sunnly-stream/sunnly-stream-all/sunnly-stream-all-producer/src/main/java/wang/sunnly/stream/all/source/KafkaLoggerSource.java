package wang.sunnly.stream.all.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * kafkaLoggerSource
 *
 * @author Sunnly
 * @create 2019/7/17 10:09
 */
public interface KafkaLoggerSource {

    public String KAFKA_LOGGER_DEBUG = "kafkaLoggerDebug";
    public String KAFKA_LOGGER_ERROR = "kafkaLoggerError";
    public String KAFKA_TEST_DEBUG = "kafkaTestDebug";

    @Output(KAFKA_LOGGER_DEBUG)
    MessageChannel kafkaLoggerDebug();

    @Output(KAFKA_LOGGER_ERROR)
    MessageChannel kafkaLoggerError();

    @Output(KAFKA_TEST_DEBUG)
    MessageChannel kafkaTestDebug();

}
