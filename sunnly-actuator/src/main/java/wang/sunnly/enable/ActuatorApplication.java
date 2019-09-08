package wang.sunnly.enable;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ActuatorApplication
 *
 * @author Sunnly
 * @create 2019/6/25 16:49
 */
@SpringBootApplication
@EnableAdminServer
public class ActuatorApplication {
    //加入如下配置
//    @Bean({"threadPoolTaskExecutor", "webMvcAsyncTaskExecutor"})
//    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
//        return new ThreadPoolTaskExecutor();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class,args);
    }
}
