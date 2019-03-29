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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * @author rutpatel
 *
 */
@Entity
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int aId;

	@NotNull
	@Size(min = 1, max = 30, message = "Street Address must be less than 30 characters")
	private String streetAddress;

	@NotNull
	@Size(min = 1, max = 25, message = "City must be less than 25 characters")
	private String city;

	@NotNull
	@Size(min = 1, max = 25, message = "State must be less than 25 characters")
	private String state;

	@NotNull
	@Size(min = 1, max = 25, message = "Country must be less than 25 characters")
	private String country;

	@NotNull
	@Positive
	@Digits(integer = 5, fraction = 0, message = "Check ZipCode Format")
	@Min(value = 1, message = "Check ZipCode Format")
	@Max(value = 99999, message = "Check ZipCode Format")
	private int zipCode;

	public Address() {
	}

	public Address(String streetAddress, String city, String state, String country, int zipCode) {
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return streetAddress + ", " + city + ", " + state + ", " + country + " [" + zipCode + "]";
	}

	public static String getFieldOrder() {
		return "aId, street, city, state, country, zipCode";
	}

	public static String getTableName() {
		return "Address";
	}

	public static String getSelectClause() {
		return "select " + getFieldOrder() + " from " + getTableName();
	}

	public static String getInsertStatement() {
		return "insert into " + getTableName() + " (" + getFieldOrder() + ") values " + "(?,?,?,?,?,?)";
	}

	public static String getUpdateStatement() {
		return "update " + getTableName()
				+ " set street = ?, city = ?, state = ?, country = ?, zipCode = ? where aId = ?;";
	}

	public static String getDeleteStatement() {
		return "delete from " + getTableName() + " where aId = ?";
	}
}