package cn.bzu.employeeprovider.dao;


import cn.bzu.employeeprovider.pojo.Department;
import cn.bzu.employeeprovider.pojo.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
public interface DepartmentMapper extends BaseMapper<Department> {
    //查询所有部门信息包含其下的职务的信息 ~没用到
    public List<Department> selectDepts();
    //查询所有职务信息
    @Select("select distinct dept_name from department")
    public List<String> selectDeptName();
    //根据部门id查询某部门包含其下的职务的信息 ~没用到
    public Department selectDeptWithJobById(Integer deptId);
    //查询各部门的人数
    @Select("select   IFNULL(t1.num, 0) from" +
            "  department   LEFT JOIN  " +
            " (SELECT  employee.dept_id,  COUNT(*) AS num   FROM   employee  GROUP BY employee.dept_id) t1 " +
            "on department.`dept_id` = t1.dept_id ")
    public List<Integer> selectDeptPeople();



//
//    public List
  //  public Admin getAdminByEmail(@Param("adminName") String name, @Param("adminEmail") String email);
}
