package cn.bzu.jobprovider.service.impl;


import cn.bzu.jobprovider.dao.JobUpdateMapper;

import cn.bzu.jobprovider.pojo.JobUpdate;
import cn.bzu.jobprovider.service.JobUpdateService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 津少
 * @since 2019-05-06
 */
@Service
public class JobUpdateServiceImpl extends ServiceImpl<JobUpdateMapper, JobUpdate> implements JobUpdateService {
    @Autowired
    private JobUpdateMapper jobUpdateMapper;
    @Override
    public void addJobUpdate(JobUpdate jobUpdate) {
        System.out.println(jobUpdate);
        jobUpdateMapper.insert(jobUpdate);
    }

    @Override
    public List<JobUpdate> getJobUpdateList() {
        return jobUpdateMapper.selectJobUpdate();
    }

    @Override
    public void deleteJobUpdate(Integer id) {

        jobUpdateMapper.deleteById(id);
    }
}
