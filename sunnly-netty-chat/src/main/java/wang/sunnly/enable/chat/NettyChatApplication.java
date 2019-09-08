package wang.sunnly.enable.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import wang.sunnly.enable.chat.config.ChatServerConfig;
import wang.sunnly.enable.chat.netty.ChatServerApplication;

/**
 * NettyChatApplication
 *
 * @author Sunnly
 * @create 2019/8/11 0011 19:11
 */
@SpringBootApplication
public class NettyChatApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(NettyChatApplication.class, args);
        ChatServerApplication chatServerApplication = context.getBean(ChatServerApplication.class);
        chatServerApplication.start();
    }
}
