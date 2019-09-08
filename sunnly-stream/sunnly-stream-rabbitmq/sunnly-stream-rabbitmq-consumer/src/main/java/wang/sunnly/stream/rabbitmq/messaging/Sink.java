package wang.sunnly.stream.rabbitmq.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

/**
 * Sink
 *
 * @author Sunnly
 * @create 2019/7/15 15:50
 */
public interface Sink {

    String SUNNLYINPUT = "sunnlyInPut";
    String SUNNLYINPUT2 = "sunnlyInput2";

    String SUNNLYKAFKA = "sunlykafka";

    @Input(SUNNLYINPUT)
    SubscribableChannel sunnlyInput();

    @Input(SUNNLYINPUT2)
    SubscribableChannel sunnlyInput2();

    @Input(SUNNLYKAFKA)
    SubscribableChannel sunnlykafka();
}
