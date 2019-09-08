package wang.sunnly.rabbitmq.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wang.sunnly.rabbitmq.constants.Constants;
import wang.sunnly.rabbitmq.service.SendMessageService;

import java.util.UUID;

/**
 * SendMessageServiceImpl
 *
 * @author Sunnly
 * @create 2019/7/15 0015 22:12
 */
@Component
public class SendMessageServiceImpl implements SendMessageService {

    private static Logger logger = LoggerFactory.getLogger(SendMessageServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(Object message) {
        rabbitTemplate.setConfirmCallback(this);

        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(Constants.SAVE_EXCHANGE_NAME,
                Constants.SAVE_QUEUE_ROUTE_KEY,message, correlationData);

        logger.info("SendMessageServiceImpl() ----> 发送消息到RabbitMQ，消息为："+message);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean isSendSuccess, String err) {
        logger.info("confirm回调方法------------->回调消息ID为："+correlationData.getId());
        if (isSendSuccess){
            logger.info("confirm回调方法--------->发送消息成功");
        }else {
            logger.info("confirm回调方法--------->发送消息失败 " + err);
        }
    }
}
