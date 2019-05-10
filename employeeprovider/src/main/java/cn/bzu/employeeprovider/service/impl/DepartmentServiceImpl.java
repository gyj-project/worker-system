package cn.bzu.employeeprovider.service.impl;


import cn.bzu.employeeprovider.dao.DepartmentMapper;
import cn.bzu.employeeprovider.dao.EmployeeMapper;
import cn.bzu.employeeprovider.pojo.Department;
import cn.bzu.employeeprovider.service.DepartmentService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 津少
 * @since 2019-04-29
 */
@Service
@Transactional
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate StringRedisTemplate;

    @Autowired
    private DepartmentMapper departmentMapper;





    @Override
    public List<Integer> deptsPeople() {
        List<Integer> nums = departmentMapper.selectDeptPeople();
        return nums;
    }

    @Override
    @Cacheable(cacheNames = {"dept"},keyGenerator = "myKeyGenerator")
    public List<Department> getDepts() {
        EntityWrapper<Department> entityWrapper = new EntityWrapper<>();
        return departmentMapper.selectList(entityWrapper);
    }
    @Override
    @Cacheable(cacheNames = {"dept"},keyGenerator = "myKeyGenerator")
    public Department getDeptById(Integer id) {
        Department department = departmentMapper.selectById(id);
        return department;
    }

    @Override
    @Cacheable(cacheNames = {"dept"},keyGenerator = "myKeyGenerator")
    public List<String> getDeptName() {
        List<String> list = departmentMapper.selectDeptName();
       // redisTemplate.opsForSet().add("dept-name-list",list);
        return list;
    }

    @Override
    @Cacheable(cacheNames = {"dept"}, keyGenerator = "myKeyGenerator")
    public Department getDeptByName(String name) {
        Department department = new Department();
        department.setDeptName(name);
        department = departmentMapper.selectOne(department);
        return department;
    }

    @Override
    @CacheEvict(value = "dept",allEntries = true)
    public void addDept(Department department) {
        departmentMapper.insert(department);
    }

    @Override
    @CacheEvict(value = "dept",allEntries = true)
    public void deleteDeptById(Integer id) {
        departmentMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "dept",allEntries = true)
    public void updateDept(Department department) {
        departmentMapper.updateById(department);
    }


}
