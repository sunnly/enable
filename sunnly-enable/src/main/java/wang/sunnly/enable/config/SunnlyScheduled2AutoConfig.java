package wang.sunnly.enable.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import wang.sunnly.enable.runner.ServerLoad2Runner;

import javax.annotation.PostConstruct;

/**
 * ServerLoadMonitorAutoConfig
 *
 * @author Sunnly
 * @create 2019/6/25 10:28
 */
@Configurable
public class SunnlyScheduled2AutoConfig {

    /**
     * 错误提醒
     */
    @PostConstruct
    protected void init() {
//        if (StringUtils.isBlank(enabledConfig)) {
//            System.err.println("~~~Please config the monitor.server.enabled property in application.yml file to enable server monitor function~~~");
//        }
    }

    @Bean
//    @ConditionalOnProperty(prefix = "sunnly.enabled", name = "run")
    protected ServerLoad2Runner serverLoad2Runner() {
        return new ServerLoad2Runner();
    }
}
