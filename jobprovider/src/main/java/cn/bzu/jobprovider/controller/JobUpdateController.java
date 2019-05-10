package cn.bzu.jobprovider.controller;


import cn.bzu.jobprovider.pojo.JobUpdate;
import cn.bzu.jobprovider.pojo.Msg;
import cn.bzu.jobprovider.service.impl.JobUpdateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 *
 * @since 2019-05-06
 */
@RestController
public class JobUpdateController {
    @Autowired
    private JobUpdateServiceImpl jobUpdateService;

    @PostMapping("/jobUpdate")
    public Msg addJobUpdate(@RequestBody JobUpdate jobUpdate){

        jobUpdateService.addJobUpdate(jobUpdate);
        return Msg.success();
    }
    @GetMapping(value = "/jobUpdate",produces = { "application/json;charset=UTF-8" })
    public Msg getJobUpdate(){
        List<JobUpdate> list = jobUpdateService.getJobUpdateList();
        return Msg.success().add("jobUpdateList",list);
    }

    @DeleteMapping(value = "/jobUpdate/{id}",produces = { "application/json;charset=UTF-8" })
    public Msg getJobUpdate(@PathVariable("id") Integer id){
        jobUpdateService.deleteJobUpdate(id);
        return Msg.success();
    }

}

