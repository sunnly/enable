package wang.sunnly.stream.rabbitmq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.sunnly.stream.rabbitmq.processor.MyMessageProcessor;
import wang.sunnly.stream.rabbitmq.service.RabbitmqService;

import java.util.HashMap;
import java.util.Map;

/**
 * RabbitmqServiceImpl
 *
 * @author Sunnly
 * @create 2019/7/15 15:28
 */
@Service
public class RabbitmqServiceImpl implements RabbitmqService {

    @Autowired
    private MyMessageProcessor myMessageProcessor;

    @Override
    public boolean sendMsg(String msg) {
        return myMessageProcessor.sendMsg(msg);
    }

    @Override
    public boolean sendMsg2(String msg) {
        Map<String,Object> headers = new HashMap<>();
        headers.put("SERIAL_NUMBER","1234");
        headers.put("BANK_NUMBER","abc");
        return myMessageProcessor.sendMsg2(msg,headers);
    }

    @Override
    public boolean sendKafkaMsg(String msg) {
        return myMessageProcessor.sendKafkaMsg(msg);
    }
}
