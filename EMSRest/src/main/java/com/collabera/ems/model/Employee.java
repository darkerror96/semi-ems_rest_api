/**
 * 
 */
package com.collabera.ems.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author rutpatel
 *
 */
@Entity
public class Employee extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int eId;

	@NotNull
	@Digits(integer = 9, fraction = 0, message = "SSN must be 9 digits")
	@Min(value = 100000000, message = "Check SSN format")
	@Max(value = 999999999, message = "Check SSN format")
	private int ssn;

	@NotNull
	@Email
	private String email;

	@NotNull
	private JobTitle jobTitle;

	@NotNull
	private Department dept;

	@NotNull
	@Positive
	@Max(value = 100000000, message = "Salary should not be greater than 100000000")
	private double salary;

	@NotNull
	@PositiveOrZero
	private int reportTo;

	@NotNull
	@PositiveOrZero
	private int isManager;

	public Employee() {
	}

	public Employee(String name, int age, Gender gender, long contactNo, Address aHome, Address aWork, int ssn,
			String email, JobTitle jobTitle, Department dept, double salary, int reportTo, int isManager) {
		super(name, age, gender, contactNo, aHome, aWork);
		this.ssn = ssn;
		this.email = email;
		this.jobTitle = jobTitle;
		this.dept = dept;
		this.salary = salary;
		this.reportTo = reportTo;
		this.isManager = isManager;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getReportTo() {
		return reportTo;
	}

	public void setReportTo(int reportTo) {
		this.reportTo = reportTo;
	}

	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}

	@Override
	public String toString() {
		return "(*)EmployeeId = " + eId + " <===> Name = " + getName() + ", Age = " + getAge() + ", Gender = "
				+ getGender() + ", ContactNo = " + getContactNo() + ",\n                        Home Address = "
				+ getaHome() + ",\n                        Work Address = " + getaWork()
				+ ",\n                        SSN = " + ssn + ", eMail = " + email + ", Job Title = " + jobTitle
				+ ", Department = " + dept + ", Salary = " + salary + ", reportTo = " + reportTo + ", isManager = "
				+ isManager;
	}

	public static String getFieldOrder() {
		return "eId, name, age, gId, contactNo, aHomeId, aWorkId, ssn, email, jId, dId, salary, isManager, manId";
	}

	public static String getTableName() {
		return "Employee";
	}

	public static String getSelectClause() {
		return "select " + getFieldOrder() + " from " + getTableName();
	}

	public static String getEmpInsertStatement() {
		return "insert into " + getTableName() + " (" + getFieldOrder() + ") values " + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}

	public static String getManInsertStatement() {
		return "insert into Manager (manId, details) values (?,?)";
	}

	public static String getEmpUpdateStatement() {
		return "update " + getTableName()
				+ " set name = ?, age = ?, gId = ?, contactNo = ?, ssn = ?, jId = ?, dId = ?, salary = ?, isManager = ?, manId = ? where eId = ?";
	}

	public static String getManUpdateStatement() {
		return "update Manager set details = ? where manId = ?";
	}

	public static String getEmpDeleteStatement() {
		return "delete from " + getTableName() + " where eId = ?;";
	}

	public static String getManDeleteStatement() {
		return "delete from Manager where manId = ?;";
	}

}