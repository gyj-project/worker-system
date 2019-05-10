package cn.bzu.employeeprovider.service;


import cn.bzu.employeeprovider.pojo.Job;
import cn.bzu.employeeprovider.pojo.JobInput;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 津少
 * @since 2019-04-29
 */
public interface JobService extends IService<Job> {
    public List<String> getJobNamesByDeptName(String deptName);

    public Job getJobByJobNameAndDeptId(String jobName,Integer deptId);

    public void updateJob(JobInput jobInput);

    public List<Job> getJobs();

    public List<Integer> jobsPeople();

    public void addJob(JobInput jobInput);

    public Job getJobWithDeptById(Integer jobId);

    public List<Job> searchJob(String type);

    public List<Integer> jobsPeopleByDeptId(Integer deptId);

    public void deleteJob(Integer id);

}
