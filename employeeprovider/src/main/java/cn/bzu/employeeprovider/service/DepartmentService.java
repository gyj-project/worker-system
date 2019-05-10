package cn.bzu.employeeprovider.service;


import cn.bzu.employeeprovider.pojo.Department;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 津少
 * @since 2019-04-29
 */
public interface DepartmentService extends IService<Department> {
    public Department getDeptById(Integer id);
    public List<String> getDeptName();
    public Department getDeptByName(String name);
    public List<Department> getDepts();
    public void addDept(Department department);
    public void deleteDeptById(Integer id);
    public void updateDept(Department department);
    public List<Integer> deptsPeople();
}
