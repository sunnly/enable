package wang.sunnly.cache.service;

/**
 * CacheService
 *
 * @author Sunnly
 * @create 2019/7/8 9:57
 */
public interface CacheService {
    String def(String username, String password);

    String mer(String username, String password);

    String ehc(String username, String password);

    String red(String username, String password);
}
