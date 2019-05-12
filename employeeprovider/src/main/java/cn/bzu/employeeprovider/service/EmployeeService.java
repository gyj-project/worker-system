package cn.bzu.employeeprovider.service;


import cn.bzu.employeeprovider.pojo.EmpInput;
import cn.bzu.employeeprovider.pojo.Employee;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 津少
 * @since 2019-04-29
 */
public interface EmployeeService extends IService<Employee> {

    public List<Employee> getEmps();

    public Employee getEmpById(Integer empId);
    public List<Employee> searchEmps(Integer pn,String type);
    public void updateEmp(EmpInput empInput) throws ParseException;
    public void addEmp(EmpInput empInput) throws ParseException;
    public void deleteEmpById(Integer id);

    public void updateLaterTime();


}
