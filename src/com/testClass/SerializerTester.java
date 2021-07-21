package com.testClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.exceptions.JSONSerializationException;
import com.pojos.Address;
import com.pojos.Car;
import com.pojos.Person;
import com.pojos.Variant;
import com.services.MyJsonSerializer;
import com.validations.JSONValidator;

public class SerializerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c= new Car();
		MyJsonSerializer jser = new MyJsonSerializer();
		c.setMake("2016");
		c.setModel("Toyota");
		c.setBuy(new Date());
		c.setCarID(1001);
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.add(2);
		arrList.add(3);
		c.setSomeArray(arrList);
		List<Variant> variants = new LinkedList<>();
		variants.add(new Variant(101, "Petrol"));
		variants.add(new Variant(102, "Diesel"));
		try {
			Person p = new Person(1001, "Abhishek", new Address("ABC street", 50));
			HashMap<String, Person> family = new HashMap<>();
			family.put("Father", new Person(1002, "Bidhan"));
			family.put("Mother", new Person(1003, "Minu"));
			p.setFamilyDetails(family);
			c.setPerson(p);
			c.setVariants(variants);
			System.out.println(jser.toJson(c));
			JSONValidator val = new JSONValidator();
			System.out.println(val.validateJSONBrackets(jser.toJson(c)));
		} catch (JSONSerializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
