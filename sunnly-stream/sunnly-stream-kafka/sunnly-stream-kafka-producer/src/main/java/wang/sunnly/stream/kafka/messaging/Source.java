package wang.sunnly.stream.kafka.messaging;

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

    @Output(SUNNLYOUTPUT)
    MessageChannel output();
}
