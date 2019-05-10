package cn.bzu.employeeprovider.pojo;

import java.io.Serializable;
import java.util.Date;

public class EmpInput implements Serializable {
    private Integer empId;
    private String empName;
    private String empEmail;
    private String empGender;
    private Date empBirth;
    private Date empIn;
    private Double empSalary;
    private String empDeptName;
    private String empJobName;
    private Integer empState;
    private Integer laterTime;

    public EmpInput() {
    }

    public EmpInput(Integer empId, String empName, String empEmail, String empGender, Date empBirth, Date empIn, Double empSalary, String empDeptName, String empJobName, Integer empState, Integer laterTime) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empGender = empGender;
        this.empBirth = empBirth;
        this.empIn = empIn;
        this.empSalary = empSalary;
        this.empDeptName = empDeptName;
        this.empJobName = empJobName;
        this.empState = empState;
        this.laterTime = laterTime;
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

    public Date getEmpBirth() {
        return empBirth;
    }

    public void setEmpBirth(Date empBirth) {
        this.empBirth = empBirth;
    }

    public Date getEmpIn() {
        return empIn;
    }

    public void setEmpIn(Date empIn) {
        this.empIn = empIn;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpDeptName() {
        return empDeptName;
    }

    public void setEmpDeptName(String empDeptName) {
        this.empDeptName = empDeptName;
    }

    public String getEmpJobName() {
        return empJobName;
    }

    public void setEmpJobName(String empJobName) {
        this.empJobName = empJobName;
    }

    public Integer getEmpState() {
        return empState;
    }

    public void setEmpState(Integer empState) {
        this.empState = empState;
    }

    public Integer getLaterTime() {
        return laterTime;
    }

    public void setLaterTime(Integer laterTime) {
        this.laterTime = laterTime;
    }

    @Override
    public String toString() {
        return "EmpInput{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empGender='" + empGender + '\'' +
                ", empBirth=" + empBirth +
                ", empIn=" + empIn +
                ", empSalary=" + empSalary +
                ", empDeptName='" + empDeptName + '\'' +
                ", empJobName='" + empJobName + '\'' +
                ", empState=" + empState +
                ", laterTime=" + laterTime +
                '}';
    }
}
