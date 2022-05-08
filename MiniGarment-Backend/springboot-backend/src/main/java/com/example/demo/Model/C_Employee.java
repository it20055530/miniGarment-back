package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")

public class C_Employee {
	
	@Id
	@Column(name = "employee_id")
	private String employeeid;
	
	@Column(name = "employee_name")
	private String employeename;
	
	@Column(name = "nic")
	private int nic;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "occupation")
	private String occupation;
	
	@Column(name = "phone_number")
	private int phonenumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "basic_sallary")
	private int basicsallary;
	
	public C_Employee() {
		
	}
	
	
	public C_Employee(String employeename, int nic, String gender, String occupation, int phonenumber, String email,
			String address, int basicsallary) {
		super();
		this.employeename = employeename;
		this.nic = nic;
		this.gender = gender;
		this.occupation = occupation;
		this.phonenumber = phonenumber;
		this.email = email;
		this.address = address;
		this.basicsallary = basicsallary;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public int getNic() {
		return nic;
	}
	public void setNic(int nic) {
		this.nic = nic;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBasicsallary() {
		return basicsallary;
	}
	public void setBasicsallary(int basicsallary) {
		this.basicsallary = basicsallary;
	}
	
	
	
	

}