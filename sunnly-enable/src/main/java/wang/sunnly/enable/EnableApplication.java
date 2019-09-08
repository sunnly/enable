package wang.sunnly.enable;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import wang.sunnly.enable.annotation.EnableSunnlyScheduled;
import wang.sunnly.enable.annotation.EnableSunnlyScheduled1;
import wang.sunnly.enable.annotation.EnableSunnlyScheduled2;

import java.io.PrintStream;

/**
 * EnableApplication
 *
 * @author Sunnly
 * @create 2019/6/25 10:14
 */
@SpringBootApplication
@EnableSunnlyScheduled1

public class EnableApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnableApplication.class,args);

    }
}
