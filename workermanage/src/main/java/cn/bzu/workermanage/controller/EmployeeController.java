package cn.bzu.workermanage.controller;

import cn.bzu.workermanage.pojo.Department;
import cn.bzu.workermanage.pojo.EmpInput;
import cn.bzu.workermanage.pojo.Msg;

import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.config.support.Parameter;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/emps")
    public Msg getEmps(@RequestParam(value="pn",defaultValue="1") Integer pn) {
        Msg msg = restTemplate.getForObject("http://EMPLOYEE-PROVIDER/emps?pn="+pn, Msg.class);
        return msg;
    }
    @GetMapping("/emp/{id}")
    public Msg getEmpById(@PathVariable("id") Integer id) {
        Msg msg = restTemplate.getForObject("http://EMPLOYEE-PROVIDER/emp/"+id, Msg.class);
        return msg;
    }
    @GetMapping("/semps")
    public Msg searchEmps(@RequestParam(value="pn",defaultValue="1") Integer pn, @RequestParam(value="type") String type) {
        if (type == "") {
            System.out.println(type+"type为空");
            return getEmps(pn);
        }
        Msg msg = restTemplate.getForObject("http://EMPLOYEE-PROVIDER/semps?pn="+pn+"&type="+type, Msg.class);
        return msg;
    }
    //HttpServletRequest request
    @PostMapping("/emp")
    public Msg addEmp(@Valid EmpInput empInput, BindingResult result){
        if(result.hasErrors()){
            List<FieldError> errors = result.getFieldErrors();
            Map<String, Object> map = new HashMap<>();
            for(FieldError fieldError : errors){
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("FieldErrors", map);
        }else{
            rabbitTemplate.convertAndSend("exchange.direct","qst.news",empInput);
            return Msg.success();
        }
    }

    @PutMapping("/emp")
    public Msg updateEmp(@Valid @RequestBody EmpInput empInput, BindingResult result){
        if(result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            Map<String, Object> map = new HashMap<>();
            for (FieldError fieldError : errors) {
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("FieldErrors", map);
        }else {
            restTemplate.put("http://EMPLOYEE-PROVIDER/emp", empInput);
            return Msg.success();
        }
    }
    @DeleteMapping("/emp/{empId}")
    public Msg deleteEmp(@PathVariable("empId") Integer empId){
        restTemplate.delete("http://EMPLOYEE-PROVIDER/emp/"+empId);
        return Msg.success();
    }


}
