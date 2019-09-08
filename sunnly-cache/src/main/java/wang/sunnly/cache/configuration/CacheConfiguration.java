package wang.sunnly.cache.configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import wang.sunnly.cache.manager.RedisCache;
import wang.sunnly.cache.manager.RedisCacheManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Configuration
 *
 * @author Sunnly
 * @create 2019/7/8 10:12
 */
//@Configurable
@Configuration
@EnableCaching(proxyTargetClass = true)
public class CacheConfiguration {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
//    @Bean
    public CacheManager simpleCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<Cache> caches = new ArrayList<Cache>();
        ConcurrentMapCache cache1 = new ConcurrentMapCache("mycache3");
        ConcurrentMapCache cache2 = new ConcurrentMapCache("mycache4");
        caches.add(cache1);
        caches.add(cache2);
        cacheManager.setCaches(caches);
        return cacheManager;
    }
//    @Bean
    public CacheManager cacheManager(){
        try {
            net.sf.ehcache.CacheManager ehcacheCacheManager
                    = new net.sf.ehcache.CacheManager(new ClassPathResource("ehcache.xml").getInputStream());

            EhCacheCacheManager cacheCacheManager = new EhCacheCacheManager(ehcacheCacheManager);
            return cacheCacheManager;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean(name="myCacheManager")
    public CacheManager myCacheManager(){
        RedisCacheManager myCacheManager = new RedisCacheManager();
        List<RedisCache> caches = new ArrayList<RedisCache>();
        RedisCache mycache = new RedisCache(redisTemplate,"mycache7");
        RedisCache mycache2 = new RedisCache(redisTemplate,"mycache8");
        caches.add(mycache);
        caches.add(mycache2);
        myCacheManager.setCaches(caches);
        return myCacheManager;
    }
}
