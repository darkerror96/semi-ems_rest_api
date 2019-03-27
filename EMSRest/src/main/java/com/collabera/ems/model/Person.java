/**
 * 
 */
package com.collabera.ems.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author rutpatel
 *
 */
@MappedSuperclass
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
	private String name;

	@NotNull
	@Min(value = 18, message = "Age should not be less than 18")
	@Max(value = 70, message = "Age should not be greater than 70")
	private int age;

	@NotNull
	@Min(value = 1, message = "1-MALE 2-FEMALE 3-OTHERS")
	@Max(value = 3, message = "1-MALE 2-FEMALE 3-OTHERS")
	private int gender;

	@NotNull
	@Digits(integer = 10, fraction = 0, message = "Contact No must be 10 digits")
	@Min(value = 1000000000, message = "Check Contact No format")
	private long contactNo;

	@OneToOne(cascade = CascadeType.ALL, targetEntity = Address.class)
	@NotNull
	private Address aHome;

	@OneToOne(cascade = CascadeType.ALL, targetEntity = Address.class)
	@NotNull
	private Address aWork;

	public Person() {
	}

	public Person(String name, int age, int gender, long contactNo, Address aHome, Address aWork) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.contactNo = contactNo;
		this.aHome = aHome;
		this.aWork = aWork;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public Address getaHome() {
		return aHome;
	}

	public void setaHome(Address aHome) {
		this.aHome = aHome;
	}

	public Address getaWork() {
		return aWork;
	}

	public void setaWork(Address aWork) {
		this.aWork = aWork;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", contactNo=" + contactNo + ", aHome="
				+ aHome + ", aWork=" + aWork + "]";
	}
}
