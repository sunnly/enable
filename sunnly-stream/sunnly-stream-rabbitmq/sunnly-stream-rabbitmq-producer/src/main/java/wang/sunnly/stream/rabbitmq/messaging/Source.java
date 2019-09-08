package wang.sunnly.stream.rabbitmq.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Source
 *
 * @author Sunnly
 * @create 2019/7/15 15:20
 */
public interface Source {
    public String SUNNLYOUTPUT = "sunnlyOutPut";
    public String SUNNLYOUTPUT2 = "sunnlyOutput2";

    public String SUNNLYKAFKA = "sunnlyKafka";

    @Output(SUNNLYOUTPUT)
    MessageChannel sunnlyOutput();

    @Output(SUNNLYOUTPUT2)
    MessageChannel sunnlyOutput2();

    @Output(SUNNLYKAFKA)
    MessageChannel sunnlyKafka();


}
