package wang.sunnly.cache.manager;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

/**
 * RedisCacheManager
 *
 * @author Sunnly
 * @create 2019/7/8 10:23
 */
public class RedisCacheManager extends AbstractCacheManager {

    private Collection<RedisCache> caches;

    public void setCaches(Collection<RedisCache> caches) {
        this.caches = caches;
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return this.caches;
    }

}
