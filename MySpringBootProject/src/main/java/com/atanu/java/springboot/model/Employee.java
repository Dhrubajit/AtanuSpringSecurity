/**
 * 
 */
package com.atanu.java.springboot.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Atanu Bhowmick
 *
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = 7676952529543942269L;
	private String empId;
	private String empName;
	private int empAge;
	private Date empDOJ;
	private Address address;

	public Employee() {
	}

	public Employee(String empId, String empName, int empAge, Date empDOJ, Address address) {
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empDOJ = empDOJ;
		this.address = address;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public Date getEmpDOJ() {
		return empDOJ;
	}

	public void setEmpDOJ(Date empDOJ) {
		this.empDOJ = empDOJ;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee : [empId = " + this.empId + ", empName = " + this.empName + ", empAge = " + this.empAge
				+ ", empDOJ = " + this.empDOJ + ", address = " + this.address + "]";
	}
}
