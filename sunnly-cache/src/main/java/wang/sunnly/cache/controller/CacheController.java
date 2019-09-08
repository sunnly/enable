package wang.sunnly.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.cache.service.CacheService;

/**
 * CacheController
 *
 * @author Sunnly
 * @create 2019/7/8 9:57
 */
@RestController
@RequestMapping("cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/def/{username}/{password}")
    public String def(@PathVariable("username") String username,
                      @PathVariable("password") String password){
        return cacheService.def(username,password);
    }
    @GetMapping("/mer/{username}/{password}")
    public String get(@PathVariable("username") String username,
                      @PathVariable("password") String password){
        return cacheService.mer(username,password);
    }
    @GetMapping("/ehc/{username}/{password}")
    public String ehc(@PathVariable("username") String username,
                      @PathVariable("password") String password){
        return cacheService.ehc(username,password);
    }
    @GetMapping("/red/{username}/{password}")
    public String red(@PathVariable("username") String username,
                      @PathVariable("password") String password){
        return cacheService.red(username,password);
    }
}
