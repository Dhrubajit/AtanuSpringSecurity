package com.atanu.java.springboot.model;

import java.io.Serializable;

/**
 * @author Atanu Bhowmick
 *
 */
public class Address implements Serializable {

	private static final long serialVersionUID = 1435280065495307283L;
	private String houseNo;
	private String streetName;
	private String city;
	private String state;

	public Address() {
	}

	public Address(String houseNo, String streetName, String city, String state) {
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
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

	@Override
	public String toString() {
		return "Address : [houseNo = " + this.houseNo + ", streetName = " + this.streetName + ", city = " + this.city
				+ ", state = " + this.state + "]";
	}
}
