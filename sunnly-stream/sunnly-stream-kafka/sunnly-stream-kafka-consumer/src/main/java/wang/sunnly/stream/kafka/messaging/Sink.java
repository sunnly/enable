package wang.sunnly.stream.kafka.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Sink
 *
 * @author Sunnly
 * @create 2019/7/15 15:50
 */
public interface Sink {

    String SUNNLYINPUT = "sunnlyInPut";

    @Input(SUNNLYINPUT)
    SubscribableChannel input();
}
