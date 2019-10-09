package cn.bzu.employeeprovider.service.impl;


import cn.bzu.employeeprovider.dao.EmployeeMapper;
import cn.bzu.employeeprovider.pojo.EmpInput;
import cn.bzu.employeeprovider.pojo.Employee;
import cn.bzu.employeeprovider.pojo.JobUpdate;
import cn.bzu.employeeprovider.pojo.Msg;
import cn.bzu.employeeprovider.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.page.PageMethod;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    DepartmentServiceImpl departmentService;
    @Autowired
    JobServiceImpl jobService;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public List<Employee> getEmps() {
        List<Employee> list = new ArrayList<Employee>();
          list =  employeeMapper.selectEmpsWithDeptAndJob();
        return list;
    }





    @Override
    @Cacheable(cacheNames = {"emp"},keyGenerator = "myKeyGenerator")
    public Employee getEmpById(Integer empId) {
        return employeeMapper.selectEmpWithDeptAndJobById(empId);
    }


    @CacheEvict(value = "emp",allEntries = true)
    public void updateEmp(EmpInput empInput) throws ParseException {
        Employee employee = new Employee();

        Integer deptId = departmentService.getDeptByName(empInput.getEmpDeptName()).getDeptId();
        Integer jobId =  jobService.getJobByJobNameAndDeptId(empInput.getEmpJobName(),deptId).getJobId();
        employee.setEmpId(empInput.getEmpId());
        employee.setDeptId(deptId);
        employee.setJobId(jobId);
        employee.setEmpName(empInput.getEmpName());
        employee.setEmpGender(empInput.getEmpGender());
        employee.setEmpEmail(empInput.getEmpEmail());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        employee.setEmpBirth(sdf.parse(sdf.format(empInput.getEmpBirth())));
        employee.setEmpIn(sdf.parse(sdf.format(empInput.getEmpIn())));
        employee.setEmpSalary(empInput.getEmpSalary());
        employee.setEmpState(empInput.getEmpState());
        employee.setLaterTime(empInput.getLaterTime());
        //旧信息
        Employee oldEmployee = employeeMapper.selectEmpWithDeptAndJobById(empInput.getEmpId());

        Integer oldJobId = oldEmployee.getJob().getJobId();
        Integer newJobId = employee.getJobId();
        Integer workerId = employee.getEmpId();
        //新旧工作对比
        if (oldJobId != newJobId){
            String nowDay = sdf.format(new Date());
            JobUpdate jobUpdate = new JobUpdate(null,oldJobId,newJobId,workerId,nowDay);
            restTemplate.postForObject("http://JOB-PROVIDER/jobUpdate",jobUpdate, Msg.class);
        }
        employeeMapper.updateById(employee);
    }
    @CacheEvict(value = "emp",allEntries = true)
    public void addEmp(EmpInput empInput) throws ParseException {
        Employee employee = new Employee();
        Integer deptId = departmentService.getDeptByName(empInput.getEmpDeptName()).getDeptId();
        Integer jobId = jobService.getJobByJobNameAndDeptId(empInput.getEmpJobName(),deptId).getJobId();
        employee.setDeptId(deptId);
        employee.setJobId(jobId);
        employee.setEmpName(empInput.getEmpName());
        employee.setEmpGender(empInput.getEmpGender());
        employee.setEmpEmail(empInput.getEmpEmail());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        employee.setEmpBirth(sdf.parse(sdf.format(empInput.getEmpBirth())));
        employee.setEmpIn(sdf.parse(sdf.format(empInput.getEmpIn())));
        employee.setEmpSalary(empInput.getEmpSalary());
        employee.setEmpState(empInput.getEmpState());

        employeeMapper.insert(employee);
    }
    @CacheEvict(value = "emp",allEntries = true)
    public void deleteEmpById(Integer id) {
        employeeMapper.deleteById(id);
    }

    @Override
    public List<Employee> searchEmps(Integer pn,String type) {
       // EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
       // System.out.println(type);
        List<Employee> list = new ArrayList<>();
        //如果搜索的是员工状态
        List<Employee> state = null;
        try {
            if(type.equals("实习"))
                state = employeeMapper.selectEmpsWithDeptAndJobByState(0);
            else if(type.equals("正式"))
                state = employeeMapper.selectEmpsWithDeptAndJobByState(1);
            else{}
            //employeeService.getEmpsByState(Integer.parseInt(type));
        }catch (Exception e){

        }
        if(state != null)
            return state;

        //如果搜索的是员工姓名

        List<Employee> name = null;
        name = employeeMapper.selectEmpsWithDeptAndJobByName(type);
                //getEmpByName(type);
        if(name != null)
            list.addAll(name);

        //如果搜索的是员工ID
        Employee id = null;
        try {
            id = employeeMapper.selectEmpWithDeptAndJobById(Integer.parseInt(type));
                    //employeeService.getEmpById(Integer.parseInt(type));
        }catch (Exception e){

        }
        if(id != null)
            list.add(id);



        //如果搜索的是部门名
        PageMethod.startPage(pn,8);
        List<Employee> dept = employeeMapper.selectEmpsWithDeptAndJobByDeptName(type);
        if (dept.size() != 0){
            return dept;
        }

        //如果搜索的是职位ming
        PageMethod.startPage(pn,8);
        List<Employee> job = employeeMapper.selectEmpsWithDeptAndJobByJobName(type);
                //employeeService.getEmpsByJobName(type);
        System.out.println(job.size());
        if (job.size() != 0){

            return job;
        }

        return list;

    }

    @Scheduled(cron = "0 0 1 1 * ?")
    public void updateLaterTime(){
        employeeMapper.updateEmpLaterTime();
    }

}
