package wang.sunnly.enable.annotation;

import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import wang.sunnly.enable.config.SunnlyScheduled1AutoConfig;
import wang.sunnly.enable.config.SunnlyScheduled2AutoConfig;

import java.lang.annotation.*;

/**
 * EnableSunnlyScheduled
 *
 * @author Sunnly
 * @create 2019/6/25 10:30
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableScheduling
@Import({SunnlyScheduled1AutoConfig.class, SunnlyScheduled2AutoConfig.class})
public @interface EnableSunnlyScheduled {
}
