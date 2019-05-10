package cn.bzu.employeeprovider.controller;


import cn.bzu.employeeprovider.dao.EmployeeMapper;
import cn.bzu.employeeprovider.pojo.EmpInput;
import cn.bzu.employeeprovider.pojo.Employee;

import cn.bzu.employeeprovider.pojo.Msg;
import cn.bzu.employeeprovider.service.EmployeeService;
import cn.bzu.employeeprovider.service.impl.EmployeeServiceImpl;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 津少
 * @since 2019-04-29
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;
	/*
	 * 分页查询员工信息*/
    @GetMapping("/emps")
	public Msg getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageMethod.startPage(pn,8);
		List<Employee> list = employeeService.getEmps();
		PageInfo pageInfo = new PageInfo(list,6);
		return Msg.success().add("pageInfo", pageInfo);

	}
	/*
	 * 根据id查询员工的详细信息并计算本月工资*/
	@GetMapping("/emp/{id}")
	public Msg getEmp(@PathVariable("id") Integer id) {
    	Double money = 0.0;
		Employee employee = employeeService.getEmpById(id);

		if(employee.getEmpState() == 1)
			money = employee.getEmpSalary() - employee.getLaterTime() * 200 > 0 ? employee.getEmpSalary() - employee.getLaterTime() * 200 : 0;
		else
			money = (employee.getEmpSalary() - employee.getLaterTime() * 200 ) * 0.8 > 0 ?  (employee.getEmpSalary() - employee.getLaterTime() * 200 ) * 0.8 : 0;
		return Msg.success().add("empInfo", employee).add("money",money);

	}
	/*
	 * 根据条件分页搜索员工信息*/
	@RequestMapping("/semps")
	public Msg searchEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn,@RequestParam("type") String type) {
		PageMethod.startPage(pn,8);
		List<Employee> list = employeeService.searchEmps(pn,type);
		PageInfo pageInfo = new PageInfo(list,6);
		return Msg.success().add("pageInfo", pageInfo);

	}
	/*
	 * 添加员工*/
	@PostMapping("/emp")
	public Msg addEmp(@RequestBody EmpInput empInput) throws ParseException {
		System.out.println(empInput.toString());
		employeeService.addEmp(empInput);
    	return Msg.success();
	}
	/*
	 * 修改员工*/
	@PutMapping("/emp")
	public void updateEmp(@RequestBody EmpInput empInput) throws ParseException {
		System.out.println( "得到id"+empInput.getEmpId());
		employeeService.updateEmp(empInput);
	}
	/*
	 * 删除员工*/
	@DeleteMapping("/emp/{id}")
	public Msg deleteEmp(@PathVariable("id") Integer empId){
		employeeService.deleteEmpById(empId);
		return Msg.success();
	}
//	@RequestMapping("/emp")
//	public Employee getEmpByName(@RequestParam(value = "name")String name) {
//    	Employee employee = new Employee();
//    	employee.setEmpName("津少");
//
//    	return employeeMapper.selectOne(employee);
//	}


}

