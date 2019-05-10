package cn.bzu.employeeprovider.controller;

import cn.bzu.employeeprovider.pojo.Department;
import cn.bzu.employeeprovider.pojo.Job;
import cn.bzu.employeeprovider.pojo.JobInput;
import cn.bzu.employeeprovider.pojo.Msg;
import cn.bzu.employeeprovider.service.JobService;
import cn.bzu.employeeprovider.service.impl.DepartmentServiceImpl;
import cn.bzu.employeeprovider.service.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 津少
 * @since 2019-04-29
 */
@RestController
public class JobController {
    @Autowired
    private JobServiceImpl jobService;
    @Autowired
    private DepartmentServiceImpl departmentService;
    /*
     * 得到职务名称列表*/
    @GetMapping("/jobs/name/{deptName}")
    public Msg getDeptName(@PathVariable("deptName") String deptName) {
        List<String> jobNames = jobService.getJobNamesByDeptName(deptName);
        return Msg.success().add("jobList",jobNames);
    }
    /*
     * 查询所有职务信息*/
    @GetMapping("/jobs")
    public Msg getJobsWithDept() {
        List<Job> jobs = jobService.getJobs();
        List<Integer> nums = jobService.jobsPeople();
        return Msg.success().add("jobList",jobs).add("people",nums);
    }
    /*
     * 添加职务*/
    @PostMapping("/job")
    public Msg addJob(@RequestBody JobInput jobInput) {
        jobService.addJob(jobInput);
        return Msg.success();
    }
    /*
     * 根据id查询某职务的具体信息*/
    @GetMapping("/job/{id}")
    public Msg getJobWithDeptById(@PathVariable("id") Integer id) {
        Job job = jobService.getJobWithDeptById(id);
        return Msg.success().add("jobInfo",job);
    }
    /*
     * 根据id查询某职务的具体信息*/
    @DeleteMapping("/job/{id}")
    public Msg deleteJob(@PathVariable("id") Integer id) {
        jobService.deleteJob(id);
        return Msg.success();
    }
    /*
     * 修改职务*/
    @PutMapping("/job")
    public Msg updateJob(@RequestBody JobInput jobInput) {
        jobService.updateJob(jobInput);
        return Msg.success();
    }
    @GetMapping("/job")
    public Msg searchJobs(@RequestParam("type") String deptName) {
        List<Job> jobs = jobService.searchJob(deptName);
        Department deptByName = departmentService.getDeptByName(deptName);
        List<Integer> nums = jobService.jobsPeopleByDeptId(deptByName.getDeptId());
        return Msg.success().add("jobsInfo",jobs).add("people",nums);
    }


}

