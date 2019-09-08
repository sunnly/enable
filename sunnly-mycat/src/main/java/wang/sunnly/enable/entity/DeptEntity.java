package wang.sunnly.enable.entity;

import org.apache.ibatis.annotations.SelectKey;

/**
 * DeptEntity
 *
 * @author Sunnly
 * @create 2019/6/27 17:32
 */
public class DeptEntity {

    private int deptno;

    private String deptname;

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
}
