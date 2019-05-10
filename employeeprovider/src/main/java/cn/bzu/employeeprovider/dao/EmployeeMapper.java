package cn.bzu.employeeprovider.dao;


import cn.bzu.employeeprovider.pojo.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 津少
 * @since 2019-04-29
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    //得到所有的员工信息包含部门、职务
    public List<Employee> selectEmpsWithDeptAndJob();
    //根据员工状态（是否实习）查询员工信息
    public List<Employee> selectEmpsWithDeptAndJobByState(@Param("empState")Integer empState);
    //根据员工姓名查询员工信息 可重名
    public List<Employee> selectEmpsWithDeptAndJobByName(@Param("empName")String empName);
    //根据员工id查询员工信息
    public Employee selectEmpWithDeptAndJobById(@Param("empId")Integer empId);
    //根据部门名称查询员工信息
    public List<Employee> selectEmpsWithDeptAndJobByDeptName(@Param("deptName")String deptName);
    //根据职务名称查询员工信息
    public List<Employee> selectEmpsWithDeptAndJobByJobName(@Param("jobName")String jobName);
    //更新员工的缺勤次数
    @Update("update employee set later_time=0")
    public void updateEmpLaterTime();



}
