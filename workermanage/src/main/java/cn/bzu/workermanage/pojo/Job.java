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
public class Job implements Serializable {


    private Integer jobId;

    private String jobName;

    private Integer deptId;

    private Department department;

    public Job() {
    }

    public Job(Integer jobId, String jobName, Integer deptId, Department department) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.deptId = deptId;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", deptId=" + deptId +
                ", department=" + department +
                '}';
    }
}
