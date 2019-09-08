package wang.sunnly.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wang.sunnly.rabbitmq.constants.Constants;

/**
 * QueueConfiguration
 *
 * @author Sunnly
 * @create 2019/7/15 0015 22:01
 */
@Configuration
public class QueueConfiguration {

    /**
     * 配置交换机实例
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(Constants.SAVE_EXCHANGE_NAME);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("sunnly.topic.exchange");
    }

    /**
     * 配置队列实例，并设置持久化队列
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue(Constants.SAVE_QUEUE_NAME, true);
    }

    /**
     * 将队列绑定到交换机上，并设置消息分发路由
     * @return
     */
    @Bean
    public Binding binding(){
//        return BindingBuilder.bind(queue())
//                .to(directExchange()).with(Constants.SAVE_QUEUE_ROUTE_KEY);
        return BindingBuilder.bind(queue()).to(topicExchange())
                .with("sunnly.*");

    }
}
