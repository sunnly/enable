package wang.sunnly.stream.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.stream.rabbitmq.service.RabbitmqService;

/**
 * RabbitmqController
 *
 * @author Sunnly
 * @create 2019/7/15 15:25
 */
@RestController
@RequestMapping("rabbitmq")
public class RabbitmqController {

    @Autowired
    RabbitmqService rabbitmqService;

    @GetMapping("send")
    public String sendMsg(@RequestParam("msg") String msg){
        return rabbitmqService.sendMsg(msg) ? "发送成功" : "发送失败";
    }
    @GetMapping("send2")
    public String sendMsg2(@RequestParam("msg") String msg){
        return rabbitmqService.sendMsg2(msg) ? "发送成功" : "发送失败";
    }

    @GetMapping("send3")
    public String sendKafkaMsg(@RequestParam("msg") String msg){
        return rabbitmqService.sendKafkaMsg(msg) ? "发送成功" : "发送失败";
    }
}
