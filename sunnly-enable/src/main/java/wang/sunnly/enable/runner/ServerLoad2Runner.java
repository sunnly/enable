package wang.sunnly.enable.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * ServerLoadMonitorRunner
 *
 * @author Sunnly
 * @create 2019/6/25 10:22
 */

public class ServerLoad2Runner implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(cron = "*/5 * * * * ?")
    public void collectServerSystemLoad(){

        logger.info("【info】---------2-------------");

    }

    @Override
    public void run(String... args) throws Exception {
        collectServerSystemLoad();
    }
}
