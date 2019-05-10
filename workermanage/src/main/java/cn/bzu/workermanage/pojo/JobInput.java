package cn.bzu.workermanage.pojo;

import java.io.Serializable;

public class JobInput implements Serializable {
    private Integer jobId;
    private String jobName;
    private String deptName;

    public JobInput(Integer jobId, String jobName, String deptName) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.deptName = deptName;
    }

    public JobInput() {
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "JobInput{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
