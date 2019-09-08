package wang.sunnly.stream.kafka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.sunnly.stream.kafka.processor.MyMessageProcessor;
import wang.sunnly.stream.kafka.service.KafkaService;

/**
 * RabbitmqServiceImpl
 *
 * @author Sunnly
 * @create 2019/7/15 15:28
 */
@Service
public class KafkaServiceImpl implements KafkaService {

    @Autowired
    private MyMessageProcessor myMessageProcessor;

    @Override
    public boolean sendMsg(String msg) {
        return myMessageProcessor.sendMsg(msg);
    }
}
