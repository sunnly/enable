package wang.sunnly.stream.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.stream.kafka.service.KafkaService;

/**
 * RabbitmqController
 *
 * @author Sunnly
 * @create 2019/7/15 15:25
 */
@RestController
@RequestMapping("rabbitmq")
public class KafkaController {

    @Autowired
    KafkaService kafkaService;

    @GetMapping("send")
    public String sendMsg(@RequestParam("msg") String msg){
        return kafkaService.sendMsg(msg) ? "发送成功" : "发送失败";
    }
}
