package cn.bzu.workermanage.controller;

import cn.bzu.workermanage.pojo.JobInput;
import cn.bzu.workermanage.pojo.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/jobs/name/{deptName}")
    public Msg getDeptName(@PathVariable("deptName") String deptName){
        Msg msg = restTemplate.getForObject("http://EMPLOYEE-PROVIDER/jobs/name/"+deptName, Msg.class);
        return msg;
    }
    @GetMapping("/jobs")
    public Msg getJobs(){
        Msg msg = restTemplate.getForObject("http://EMPLOYEE-PROVIDER/jobs", Msg.class);
        return msg;
    }

    @PostMapping("/job")
    public Msg addJob(@RequestBody JobInput jobInput) {
        System.out.println(jobInput.toString());
        Msg msg = restTemplate.postForObject("http://EMPLOYEE-PROVIDER/job",jobInput,Msg.class);
        return msg;
    }
    @GetMapping("/job/{id}")
    public Msg getJobWithDeptById(@PathVariable("id") Integer id){
       return restTemplate.getForObject("http://EMPLOYEE-PROVIDER/job/"+id,Msg.class);
    }
    @DeleteMapping("/job/{id}")
    public Msg deleteJob(@PathVariable("id") Integer id){
         restTemplate.delete("http://EMPLOYEE-PROVIDER/job/"+id);
         return Msg.success();
    }

    @PutMapping("/job")
    public Msg updateJob(@RequestBody JobInput jobInput) {
        System.out.println(jobInput.toString());
        restTemplate.put("http://EMPLOYEE-PROVIDER/job",jobInput);
        return Msg.success();
    }

    @GetMapping("/job")
    public Msg searchJobs(@RequestParam("type") String deptName) {
        Msg msg = restTemplate.getForObject("http://EMPLOYEE-PROVIDER/job?type="+deptName,Msg.class);
        return msg;
    }

    @DeleteMapping("/record/{id}")
    public Msg deleteJobUpdate(@PathVariable("id") Integer id) {
        restTemplate.delete("http://JOB-PROVIDER/jobUpdate/"+id);
        return Msg.success();
    }

    @GetMapping("/records")
    public Msg getRecord(){
        Msg msg = restTemplate.getForObject("http://JOB-PROVIDER/jobUpdate", Msg.class);
        return msg;
    }


}
