package wang.sunnly.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.rabbitmq.entity.UserEntity;
import wang.sunnly.rabbitmq.service.UserService;

/**
 * RabbitMqController
 *
 * @author Sunnly
 * @create 2019/7/15 10:21
 */
@RestController
@RequestMapping("rabbit")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/send")
    public String testMq(){

        for (int i=0; i<20;i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setName("zhangsan"+i);
            userEntity.setAge(22+i);
            userService.save(userEntity);
        }
        return "发送成功";
    }
}
