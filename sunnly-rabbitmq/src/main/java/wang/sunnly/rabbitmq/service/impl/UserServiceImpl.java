package wang.sunnly.rabbitmq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.sunnly.rabbitmq.entity.UserEntity;
import wang.sunnly.rabbitmq.service.SendMessageService;
import wang.sunnly.rabbitmq.service.UserService;

/**
 * UserService
 *
 * @author Sunnly
 * @create 2019/7/15 0015 22:19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SendMessageService sendMessageService;

    public Long save(UserEntity userEntity){

        sendMessageService.sendMessage(userEntity.getName());
        return userEntity.getId();
    }
}
