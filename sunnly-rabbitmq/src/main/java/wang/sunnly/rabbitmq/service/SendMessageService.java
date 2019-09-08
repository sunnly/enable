package wang.sunnly.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * SendMessageService
 *
 * @author Sunnly
 * @create 2019/7/15 0015 22:09
 */
public interface SendMessageService extends RabbitTemplate.ConfirmCallback {

    void sendMessage(Object message);
}
