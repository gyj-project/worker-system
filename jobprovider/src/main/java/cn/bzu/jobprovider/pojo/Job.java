package cn.bzu.jobprovider.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 津少
 * @since 2019-04-29
 */
public class Job implements Serializable {



    @TableId(value = "job_id", type = IdType.AUTO)
    private Integer jobId;
    @TableField("job_name")
    private String jobName;
    @TableField("dept_id")
    private Integer deptId;

    public Job(Integer jobId, String jobName, Integer deptId) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.deptId = deptId;
    }

    public Job() {
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
