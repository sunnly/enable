package wang.sunnly.rabbitmq.service;

import org.springframework.beans.factory.annotation.Autowired;
import wang.sunnly.rabbitmq.entity.UserEntity;

/**
 * UserService
 *
 * @author Sunnly
 * @create 2019/7/15 0015 22:19
 */
public interface UserService {

    public Long save(UserEntity userEntity);
}
