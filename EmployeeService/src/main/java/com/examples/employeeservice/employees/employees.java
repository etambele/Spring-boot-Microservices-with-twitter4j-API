package com.examples.employeeservice.employees;

public class employees {

	private String empid;
	private String firstname;
	private String lastname;
	private String status;
	private String currentrating;
	private String sex;
	private String oaRating;
	
	public employees() {
		
	}
	
	public employees(String empid, String firstname, String lastname, String status, String currentrating, String sex,
			String oaRating) {
		this.empid = empid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.status = status;
		this.currentrating = currentrating;
		this.sex = sex;
		this.oaRating = oaRating;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrentrating() {
		return currentrating;
	}

	public void setCurrentrating(String currentrating) {
		this.currentrating = currentrating;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getOaRating() {
		return oaRating;
	}

	public void setOaRating(String oaRating) {
		this.oaRating = oaRating;
	}


	
	
	
	
}
