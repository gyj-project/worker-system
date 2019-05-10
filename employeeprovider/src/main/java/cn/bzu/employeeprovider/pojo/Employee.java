package cn.bzu.employeeprovider.pojo;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 津少
 * @since 2019-04-29
 */
public class Employee implements Serializable {

    @TableId(value = "emp_id", type = IdType.AUTO)
    private Integer empId;
    @TableField("emp_name")
    private String empName;
    @TableField("emp_email")
    @Email
    private String empEmail;
    @TableField("emp_gender")
    private String empGender;
    @JsonFormat(pattern="yyyy-MM-dd")
    @TableField("emp_in")
    private Date empIn;
    @JsonFormat(pattern="yyyy-MM-dd")
    @TableField("emp_birth")
    private Date empBirth;
    @TableField("dept_id")
    private Integer deptId;
    @TableField("job_id")
    private Integer jobId;
    @TableField("emp_salary")
    private Double empSalary;
    @TableField("later_time")
    private Integer laterTime;
    @TableField("emp_state")
    private Integer empState;
    @TableField(exist = false)
    private Department department;
    @TableField(exist = false)
    private Job job;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(Integer empId, String empName, String empEmail, String empGender, Date empIn, Date empBirth, Integer deptId, Integer jobId, Double empSalary, Integer laterTime, Integer empState) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empGender = empGender;
        this.empIn = empIn;
        this.empBirth = empBirth;
        this.deptId = deptId;
        this.jobId = jobId;
        this.empSalary = empSalary;
        this.laterTime = laterTime;
        this.empState = empState;
    }

    public Employee() {
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public Date getEmpIn() {
        return empIn;
    }

    public void setEmpIn(Date empIn) {
        this.empIn = empIn;
    }

    public Date getEmpBirth() {
        return empBirth;
    }

    public void setEmpBirth(Date empBirth) {
        this.empBirth = empBirth;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    public Integer getLaterTime() {
        return laterTime;
    }

    public void setLaterTime(Integer laterTime) {
        this.laterTime = laterTime;
    }

    public Integer getEmpState() {
        return empState;
    }

    public void setEmpState(Integer empState) {
        this.empState = empState;
    }



    @Override
    public String toString() {
        return "Employee{" +
        ", empId=" + empId +
        ", empName=" + empName +
        ", empEmail=" + empEmail +
        ", empGender=" + empGender +
        ", empIn=" + empIn +
        ", empBirth=" + empBirth +
        ", deptId=" + deptId +
        ", jobId=" + jobId +
        ", empSalary=" + empSalary +
        ", laterTime=" + laterTime +
        ", empState=" + empState +
        "}";
    }
}
