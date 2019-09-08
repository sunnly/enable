package wang.sunnly.stream.all.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import wang.sunnly.stream.all.processor.KafkaMessageProcessor;
import wang.sunnly.stream.all.service.KafKaLoggerService;

/**
 * RabbitLoggerServiceImpl
 *
 * @author Sunnly
 * @create 2019/7/17 12:04
 */
@Service
public class KafkaLoggerServiceImpl implements KafKaLoggerService {

    @Autowired
//    @Qualifier()
    KafkaMessageProcessor kafkaMessageProcessor;

    @Override
    public boolean debug(String message) {
        return kafkaMessageProcessor.debug(message);
    }

    @Override
    public boolean error(String message) {
        return kafkaMessageProcessor.error(message);
    }

    @Override
    public boolean test(String message) {
        return kafkaMessageProcessor.test(message);
    }
}
