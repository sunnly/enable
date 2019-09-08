package wang.sunnly.enable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * MycatApplication
 *
 * @author Sunnly
 * @create 2019/6/27 16:01
 */
@SpringBootApplication
@MapperScan("wang.sunnly.enable.mapper")
public class MycatApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycatApplication.class, args);
    }
}
