package cn.bzu.jobprovider.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author 津少
 * @since 2019-05-06
 */

public class JobUpdate implements Serializable {

    @TableId(value = "job_update_id", type = IdType.AUTO)
    private Integer jobUpdateId;
    @TableField("before_id")
    private Integer beforeId;
    @TableField("after_id")
    private Integer afterId;
    @TableField("update_worker")
    private Integer updateWorker;
    @TableField("update_time")
    private String updateTime;

    public JobUpdate() {
    }

    public JobUpdate(Integer jobUpdateId, Integer beforeId, Integer afterId, Integer updateWorker, String updateTime) {
        this.jobUpdateId = jobUpdateId;
        this.beforeId = beforeId;
        this.afterId = afterId;
        this.updateWorker = updateWorker;
        this.updateTime = updateTime;
    }

    public Integer getJobUpdateId() {
        return jobUpdateId;
    }

    public void setJobUpdateId(Integer jobUpdateId) {
        this.jobUpdateId = jobUpdateId;
    }

    public Integer getBeforeId() {
        return beforeId;
    }

    public void setBeforeId(Integer beforeId) {
        this.beforeId = beforeId;
    }

    public Integer getAfterId() {
        return afterId;
    }

    public void setAfterId(Integer afterId) {
        this.afterId = afterId;
    }

    public Integer getUpdateWorker() {
        return updateWorker;
    }

    public void setUpdateWorker(Integer updateWorker) {
        this.updateWorker = updateWorker;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
