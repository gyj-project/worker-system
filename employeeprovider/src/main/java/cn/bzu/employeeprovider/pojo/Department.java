package cn.bzu.employeeprovider.pojo;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author 津少
 * @since 2019-04-29
 */
public class Department implements Serializable {


    @TableId(value = "dept_id", type = IdType.AUTO)
    private Integer deptId;
    @TableField("dept_name")
    private String deptName;
    @TableField("dept_manager")
    private String deptManager;

    @TableField(exist = false)
    private List<Job> jobList;

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public String getDeptManager() {
        return deptManager;
    }

    public void setDeptManager(String deptManager) {
        this.deptManager = deptManager;
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
    public Department() {
        super();
    }

    public Department(Integer deptId, String deptName, String deptManager) {
        super();
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptManager = deptManager;
    }


}
