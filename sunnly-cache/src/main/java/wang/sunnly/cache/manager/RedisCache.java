package wang.sunnly.cache.manager;

import com.alibaba.fastjson.JSON;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * RedisCache
 *
 * @author Sunnly
 * @create 2019/7/8 10:51
 */
public class RedisCache implements Cache {

    private RedisTemplate<String, String> redisTemplate;

    String name;

    public RedisCache(){

    }

    public RedisCache(RedisTemplate<String, String> redisTemplate,String name){
        this.redisTemplate = redisTemplate;
        this.name = name;
    }


    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object getNativeCache() {
        Set<String> keys = redisTemplate.keys(getKey());
        Map<String ,String> map = new HashMap<>();
        if (keys.iterator().hasNext()){
            String key = keys.iterator().next();
            map.put(key,redisTemplate.opsForValue().get(key));
        }
        return map;
    }

    @Override
    public ValueWrapper get(Object key) {
        ValueWrapper result = null;
        Object thevalue = getRedis(key);
        if(thevalue!=null) {
            result = new SimpleValueWrapper(thevalue);
        }else{
        }
        return result;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        ValueWrapper valueWrapper = get(key);
        if (valueWrapper != null){
            return JSON.parseObject(valueWrapper.get().toString(),type);
        }
        return null;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
//        ValueWrapper valueWrapper = get(key);
//        if (valueWrapper != null){
//            try {
//                return JSON.parseObject(valueWrapper.get().toString(), valueLoader.call().getClass());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        redisTemplate.opsForValue().set(getKey(key), JSON.toJSONString(value));
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        Boolean aBoolean = redisTemplate.opsForValue()
                .setIfAbsent(getKey(key), JSON.toJSONString(value));
        return get(key);
    }

    @Override
    public void evict(Object key) {
        redisTemplate.opsForValue().set(getKey(key),"",1);
    }

    @Override
    public void clear() {
        Set<String> keys = redisTemplate.keys(getKey());
        if (keys.iterator().hasNext()){
            String key = keys.iterator().next();
            redisTemplate.opsForValue().set(key,"",1);
        }
    }


    private String getKey(){
        return String.format("cache:===redis===:%s",this.name);
    }

    private String getKey(Object key){
        return String.format("cache:===redis===:%s:%s",this.name , key);
    }

    private String getRedis(Object key){
        return redisTemplate.opsForValue().get(getKey(key));
    }
}
