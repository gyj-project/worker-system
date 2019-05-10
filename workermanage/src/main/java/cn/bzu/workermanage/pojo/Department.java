package cn.bzu.workermanage.pojo;


import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 津少
 * @since 2019-04-29
 */
public class Department implements Serializable {


    private Integer deptId;

    private String deptName;

    private String deptManager;

    public Department() {
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptManager() {
        return deptManager;
    }

    public void setDeptManager(String deptManager) {
        this.deptManager = deptManager;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptManager='" + deptManager + '\'' +
                '}';
    }
}
