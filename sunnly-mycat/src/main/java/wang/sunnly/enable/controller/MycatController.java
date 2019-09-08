package wang.sunnly.enable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.enable.entity.DeptEntity;
import wang.sunnly.enable.mapper.MycatMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * MycatController
 *
 * @author Sunnly
 * @create 2019/6/27 16:12
 */
@RestController
@RequestMapping("mycat")
public class MycatController {

    @Autowired
    private MycatMapper mycatMapper;

    @GetMapping("/test")
    public String  test(){
        return "successhhhh";
    }
    @GetMapping("/rest")
    public List<Map<String, Object>> mycat(){
        List<Map<String, Object>> all = mycatMapper.all();
        return all;
    }

    @GetMapping("/in")
    public int insertUser(){

        return mycatMapper.insertUser(UUID.randomUUID().toString().replace("-",""),
                "mycat","mycat");
    }

    @GetMapping("/ind/{name}")
    public int insertDept(@PathVariable("name") String name){

        DeptEntity deptEntity = new DeptEntity();
        deptEntity.setDeptname(name);
        int i = mycatMapper.insertDept(deptEntity);

        return i;
    }

    @GetMapping("up")
    public int updateUser(){

        return mycatMapper.updateUser("1f036ae198af11e9aa2f0242ac190008",
                "mycat11","mycat11");
    }
}
