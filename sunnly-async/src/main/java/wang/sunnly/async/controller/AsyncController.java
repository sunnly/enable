package wang.sunnly.async.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AsyncController
 *
 * @author Sunnly
 * @create 2019/7/18 0018 0:35
 */
@RestController
@RequestMapping("async")
public class AsyncController {

    @GetMapping()
    public String get(){
        return "success";
    }
}
