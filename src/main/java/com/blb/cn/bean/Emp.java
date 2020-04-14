package com.blb.cn.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class Emp {
    private Integer empId;

    //@Pattern是自定义校验规则，regexp是正则表达式，message提示信息
    @Pattern(regexp = "/^[a-z0-9_-]{3,16}$/",
    		message = "用户名必须是a到z。。。")
    private String empName;

    private String gender;

    //@Email封装好的一些校验规则
    @Email
    private String email;

    private Integer dId;
    
    private Dept dept;
    
    
    public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Integer empId, String empName, String gender, String email, Integer dId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.email = email;
		this.dId = dId;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
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
        this.empName = empName == null ? null : empName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", gender=" + gender + ", email=" + email + ", dId="
				+ dId + ", dept=" + dept + "]";
	}
    
    
    
}