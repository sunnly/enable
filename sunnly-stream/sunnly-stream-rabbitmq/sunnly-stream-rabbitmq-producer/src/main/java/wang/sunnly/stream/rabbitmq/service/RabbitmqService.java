package wang.sunnly.stream.rabbitmq.service;

/**
 * RabbitmqService
 *
 * @author Sunnly
 * @create 2019/7/15 15:25
 */
public interface RabbitmqService {
    public boolean sendMsg(String msg);

    public boolean sendMsg2(String msg);

    public boolean sendKafkaMsg(String msg);
}
