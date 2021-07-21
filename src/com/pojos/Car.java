package com.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.annotations.JField;

public class Car {
	@JField
	private int carID;
	
	@JField
	private String make;
	
	@JField
	private String model;
	
	@JField
	private Date buy;
	
	@JField
	private ArrayList<Integer> someArray;
	
	@JField(aggregation=true)
	private Person person;
	
	
	@JField(aggregation=true,listify=true)
	private List<Variant> variants;
	
	public List<Variant> getVariants() {
		return variants;
	}

	public void setVariants(List<Variant> variants) {
		this.variants = variants;
	}

	public ArrayList<Integer> getSomeArray() {
		return someArray;
	}

	public void setSomeArray(ArrayList<Integer> someArray) {
		this.someArray = someArray;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public Date getBuy() {
		return buy;
	}

	public void setBuy(Date buy) {
		this.buy = buy;
	}

	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}
