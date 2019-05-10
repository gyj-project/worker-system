package cn.bzu.jobprovider.pojo;

import java.io.Serializable;

public class Job2 implements Serializable {
    private String newJob;

    public String getOldJob() {
        return newJob;
    }

    public void setOldJob(String newJob) {
        this.newJob = newJob;
    }
}

