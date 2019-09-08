package wang.sunnly.enable.mapper;

import org.apache.ibatis.annotations.*;
import wang.sunnly.enable.entity.DeptEntity;

import java.util.List;
import java.util.Map;

/**
 * MycatMapper
 *
 * @author Sunnly
 * @create 2019/6/27 16:14
 */
public interface MycatMapper {

    @Select("SELECT * FROM tb_user")
    public List<Map<String,Object>> all();

    @Insert("INSERT INTO tb_user(id,`name`,`password`) " +
            "VALUE(#{id},#{username},#{password});")
    public int insertUser(@Param("id") String id,
                          @Param("username") String username,
                          @Param("password") String password);

    @Insert("INSERT INTO tb_detp(deptno,deptname) VALUES(NEXT VALUE FOR MYCATSEQ_DEPTID,#{deptEntity.deptname});")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="deptEntity.deptno",
            before=false, resultType=int.class)
    public int insertDept(@Param("deptEntity")DeptEntity deptEntity);


    @Update("UPDATE tb_user SET `name`=#{username} WHERE id=#{id}")
    public int updateUser(@Param("id") String id,
                          @Param("username") String username,
                          @Param("password") String password);
}
