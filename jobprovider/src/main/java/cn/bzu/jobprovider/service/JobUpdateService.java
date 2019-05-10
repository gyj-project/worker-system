package cn.bzu.jobprovider.service;


import cn.bzu.jobprovider.pojo.JobUpdate;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 津少
 * @since 2019-05-06
 */
public interface JobUpdateService extends IService<JobUpdate> {
    public void addJobUpdate(JobUpdate jobUpdate);
    public List<JobUpdate> getJobUpdateList();
    public void deleteJobUpdate(Integer id);

}
