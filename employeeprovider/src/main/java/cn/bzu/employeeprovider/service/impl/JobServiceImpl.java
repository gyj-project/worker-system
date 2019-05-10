package cn.bzu.employeeprovider.service.impl;


import cn.bzu.employeeprovider.dao.JobMapper;
import cn.bzu.employeeprovider.pojo.Department;
import cn.bzu.employeeprovider.pojo.Job;
import cn.bzu.employeeprovider.pojo.JobInput;
import cn.bzu.employeeprovider.service.JobService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 津少
 * @since 2019-04-29
 */
@Service
@Transactional
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {

    @Autowired
    RedisTemplate redisTemplate;


    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private DepartmentServiceImpl departmentService;


    @Override
    @CacheEvict(value = "dept",allEntries=true)
    public List<String> getJobNamesByDeptName(String deptName) {
        Integer deptId = departmentService.getDeptByName(deptName).getDeptId();
        return jobMapper.selectJobNameById(deptId);
    }

    @Override
    public List<Job> getJobs() {
        List<Job> jobs = jobMapper.selectJobWithDept();
        return jobs;
    }

    @Override
    @CacheEvict(value = "job",allEntries = true)
    public Job getJobWithDeptById(Integer jobId) {
        return jobMapper.selectJobWithDeptById(jobId);
    }

    @Override
    @CacheEvict(value = "job",allEntries = true)
    public void addJob(JobInput jobInput) {
       Job job = new Job();
       Integer deptId = departmentService.getDeptByName(jobInput.getDeptName()).getDeptId();
       job.setDeptId(deptId);
       job.setJobName(jobInput.getJobName());
       jobMapper.insert(job);

    }

    @Override
    @Cacheable(cacheNames = {"job"},keyGenerator = "myKeyGenerator")
    public List<Integer> jobsPeople() {
        List<Integer> nums = jobMapper.selectJobPeople();
        return nums;
    }

    @Override
    @Cacheable(cacheNames = {"job"},keyGenerator = "myKeyGenerator")
    public Job getJobByJobNameAndDeptId(String jobName, Integer deptId) {
        Job job = new Job();
        job.setDeptId(deptId);
        job.setJobName(jobName);
        return jobMapper.selectOne(job);
    }

    @Override
    @Cacheable(cacheNames = {"job"},keyGenerator = "myKeyGenerator")
    public List<Integer> jobsPeopleByDeptId(Integer deptId) {
        List<Integer> nums = jobMapper.selectJobPeopleByDeptId(deptId);
        return nums;
    }

    @Override
    @CacheEvict(value = "job",allEntries = true)
    public void deleteJob(Integer id) {
        jobMapper.deleteById(id);
    }

    @Override
    public List<Job> searchJob(String type) {
        Department deptByName = departmentService.getDeptByName(type);
        List<Job> jobs = jobMapper.selectJobWithDeptByDeptId(deptByName.getDeptId());
        return jobs;
    }

    @Override
    @CacheEvict(value = "job",allEntries = true)
    public void updateJob(JobInput jobInput) {
        Job job = new Job();
        job.setJobId(jobInput.getJobId());
        Integer deptId = departmentService.getDeptByName(jobInput.getDeptName()).getDeptId();
        job.setDeptId(deptId);
        job.setJobName(jobInput.getJobName());
        jobMapper.updateById(job);
    }

    public int getJobNumByDeptId(Integer deptId) {
        EntityWrapper<Job> wrapper = new EntityWrapper<>();
        Integer integer = jobMapper.selectCount(wrapper);
        return integer;
    }
}
