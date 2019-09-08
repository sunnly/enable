package wang.sunnly.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import wang.sunnly.rabbitmq.constants.Constants;

/**
 * ReceiveMessage
 *
 * @author Sunnly
 * @create 2019/7/15 0015 22:28
 */
@Component
@RabbitListener(queues = Constants.SAVE_QUEUE_NAME)
public class ReceiveMessage {

    private static Logger logger = LoggerFactory.getLogger(ReceiveMessage.class);

    @RabbitHandler
    public void receiveMessage(String userName){
        logger.info("接收到消息，用户名:"+userName);
    }
}
