package cn.bzu.employeeprovider.dao;


import cn.bzu.employeeprovider.pojo.Job;
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
public interface JobMapper extends BaseMapper<Job> {
    //得到职务名称列表
    @Select("select distinct job_name from job where dept_id = #{deptId}")
    public List<String> selectJobNameById(Integer deptId);
    //查询所有的职务信息包括所属部门的信息
    public List<Job> selectJobWithDept();
    //通过id查询某职务的具体信息包括所属部门信息
    public Job selectJobWithDeptById(@Param("jobId") Integer jobId);
    //通过部门id查询职务
    public List<Job> selectJobWithDeptByDeptId(@Param("deptId") Integer deptId);

    //查询各职务人数
    @Select("select   IFNULL(t1.num, 0) from" +
            "  job   LEFT JOIN  " +
            " (SELECT  employee.job_id,  COUNT(*) AS num   FROM   employee  GROUP BY employee.job_id) t1 " +
            "on job.`job_id` = t1.job_id ")
    public List<Integer> selectJobPeople();
    //查询某部门下职务人数
    @Select("select   IFNULL(t1.num, 0) from (SELECT * FROM job where dept_id = #{deptId}) as job " +
            "  LEFT JOIN  " +
            "             (SELECT  employee.job_id,  COUNT(*) AS num   FROM   employee  GROUP BY employee.job_id) t1 " +
            "            on job.`job_id` = t1.job_id ")
    public List<Integer> selectJobPeopleByDeptId(Integer deptId);


}
