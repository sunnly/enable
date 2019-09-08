package wang.sunnly.stream.kafka.service;

/**
 * RabbitmqService
 *
 * @author Sunnly
 * @create 2019/7/15 15:25
 */
public interface KafkaService {
    public boolean sendMsg(String msg);
}
