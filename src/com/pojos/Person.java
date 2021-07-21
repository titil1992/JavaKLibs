package com.pojos;

import java.util.Map;

import com.annotations.JField;

public class Person {
	@JField
	private int carID;
	@JField
	private String name;
	@JField(aggregation=true)
	private Address address;
	@JField(aggregation=true, mapify=true)
	private Map<String, Person> familyDetails;
	
	public Map<String, Person> getFamilyDetails() {
		return familyDetails;
	}
	public void setFamilyDetails(Map<String, Person> familyDetails) {
		this.familyDetails = familyDetails;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person(int carID, String name) {
		super();
		this.carID = carID;
		this.name = name;
	}
	public Person(int carID, String name, Address address) {
		super();
		this.carID = carID;
		this.name = name;
		this.address = address;
	}
	
	
}
