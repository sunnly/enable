package wang.sunnly.enable.runner;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.net.InetAddress;

/**
 * ServerLoad1Runner
 *
 * @author Sunnly
 * @create 2019/6/25 10:22
 */

public class ServerLoad1Runner implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(cron = "*/3 * * * * ?")
    public void collectServerSystemLoad(){

        logger.info("【info】---------1-------------");

    }

    @Override
    public void run(String... args) throws Exception {
        collectServerSystemLoad();
    }
}
