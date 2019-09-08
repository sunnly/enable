package wang.sunnly.stream.all.service;

/**
 * RabbitLoggerService
 *
 * @author Sunnly
 * @create 2019/7/17 12:04
 */
public interface RabbitLoggerService {

    boolean debug(String message);

    boolean error(String message);

    boolean test(String message);
}
