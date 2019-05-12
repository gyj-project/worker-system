package cn.bzu.workermanage.controller;

import cn.bzu.workermanage.pojo.Department;
import cn.bzu.workermanage.pojo.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class DepartmentController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/depts-name")
    public Msg getDeptList() {
        Msg msg = restTemplate.getForObject("http://EMPLOYEE-PROVIDER/depts-name",Msg.class);
        return msg;
    }
    @GetMapping("/depts")
    public Msg getDepts() {
        return restTemplate.getForObject("http://EMPLOYEE-PROVIDER/depts", Msg.class);
    }

    @GetMapping("/dept/{id}")
    public Msg getDeptById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject("http://EMPLOYEE-PROVIDER/dept/"+id, Msg.class);
    }

    @DeleteMapping("/dept/{id}")
    public Msg deleteDeptById(@PathVariable("id") Integer id) {
        restTemplate.delete("http://EMPLOYEE-PROVIDER/dept/"+id);
        return Msg.success();
    }

    @PutMapping("/dept")
    public Msg updateDeptById(@RequestBody Department department){
        restTemplate.put("http://EMPLOYEE-PROVIDER/dept",department);
        return Msg.success();
    }

    @PostMapping("/dept")
    public Msg addDept(@RequestBody Department department){
        Msg msg = restTemplate.postForObject("http://EMPLOYEE-PROVIDER/dept", department, Msg.class);
        return msg;
    }
}
