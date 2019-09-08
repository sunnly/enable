package wang.sunnly.stream.all.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * RabbitLoggerSink
 *
 * @author Sunnly
 * @create 2019/7/17 0017 19:31
 */
public interface RabbitLoggerSink {

    public String RABBIT_LOGGER_DEBUG = "rabbitLoggerDebug";
    public String RABBIT_LOGGER_ERROR = "rabbitLoggerError";
    public String RABBIT_TEST_DEBUG = "rabbitTestDebug";

    @Input(RABBIT_LOGGER_DEBUG)
    SubscribableChannel rabbitLoggerDebug();

    @Input(RABBIT_LOGGER_ERROR)
    SubscribableChannel rabbitLoggerError();

    @Input(RABBIT_TEST_DEBUG)
    SubscribableChannel rabbitTestDebug();
}
