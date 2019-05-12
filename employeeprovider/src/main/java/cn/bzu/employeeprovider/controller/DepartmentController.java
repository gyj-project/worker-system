package cn.bzu.employeeprovider.controller;


import cn.bzu.employeeprovider.pojo.Department;
import cn.bzu.employeeprovider.pojo.Msg;
import cn.bzu.employeeprovider.service.DepartmentService;
import cn.bzu.employeeprovider.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
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
public class DepartmentController {
    @Autowired
     DepartmentServiceImpl departmentService;
    /*
    * 通过部门名称查找部门*/
    @GetMapping("/dept")
    public Department getDeptByName(@RequestParam("name") String name){
        return departmentService.getDeptByName(name);
    }
    /*
     * 通过部门id查找部门*/
    @GetMapping("/dept/{id}")
    public Msg getDeptById(@PathVariable("id") Integer id){
        return Msg.success().add("deptInfo",departmentService.getDeptById(id));
    }
    /*
     * 得到部门列表*/
    @GetMapping("/depts-name")
    public Msg getDeptName() {
        List<String> deptName = departmentService.getDeptName();
        return Msg.success().add("deptList",deptName);
    }
    /*
     * 得到所有部门信息及其人数*/
    @GetMapping("/depts")
    public Msg getDepts() {
        List<Integer> nums = departmentService.deptsPeople();
        List<Department> depts = departmentService.getDepts();
        return Msg.success().add("deptList",depts).add("deptsPeople",nums);
    }
    /*
     * 更改部门信息*/
    @PutMapping("/dept")
    public void updateDeptById(@RequestBody Department department){
        departmentService.updateDept(department);
    }
    /*
     * 新增部门信息*/
    @PostMapping("/dept")
    public void addDept(@RequestBody Department department){
        System.out.println(department.toString());
        departmentService.addDept(department);
    }
    /*
     * 通过id删除部门*/
    @DeleteMapping("/dept/{id}")
    public Msg deleteEmp(@PathVariable("id") Integer empId){
       departmentService.deleteDeptById(empId);
        return Msg.success();
    }



}

