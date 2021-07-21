package com.services;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.annotations.JField;
import com.exceptions.JSONSerializationException;
import com.services.api.JSONSerializationInterface;
import com.validations.JSONValidator;

public class MyJsonSerializer implements JSONSerializationInterface{
	
	private JSONValidator jVal;
	
	
	public JSONValidator getjVal() {
		return jVal;
	}

	public void setjVal(JSONValidator jVal) {
		this.jVal = jVal;
	}

	public String toJson(Object object) throws JSONSerializationException{
		Map<String, Object> jsonElements = new HashMap<>();
		try {	
			if(object != null) {
				Class<?> objectClass = object.getClass();
				for(Field field:objectClass.getDeclaredFields()) {
					if(field.isAnnotationPresent(JField.class)) {
						field.setAccessible(true);
						if(field.getDeclaredAnnotation(JField.class).aggregation() && field.getDeclaredAnnotation(JField.class).listify()) {
							List<Object> obList = (List<Object>)field.get(object);
							ArrayList<Object> newList = new ArrayList<>();
							if(obList!=null) {
								for(Object ob:obList) {
									newList.add(toJson(ob));
								}
							}
							jsonElements.put(getSerializedKey(field), newList.isEmpty()?"[]":newList);	
						}
						else if(field.getDeclaredAnnotation(JField.class).aggregation() && field.getDeclaredAnnotation(JField.class).mapify()) {
							Map<String, Object> inMap = (Map<String, Object>)field.get(object);
							if(inMap==null) {
								jsonElements.put(getSerializedKey(field), "{}");
							}
							else {
								HashMap<String, Object> outMap = new HashMap<>();
								for(Entry<String, Object> entry:inMap.entrySet()) {
									outMap.put(entry.getKey(), toJson(entry.getValue()));
								}
								jsonElements.put(getSerializedKey(field), outMap);
							}
						}
						else if(field.getDeclaredAnnotation(JField.class).aggregation()) {
							if(field.get(object) == null){
								jsonElements.put(getSerializedKey(field), "{}");
							}
							else {
								jsonElements.put(getSerializedKey(field), toJson(field.get(object)));
							}
							
						}
						else {
							if(field.get(object) == null) {
								jsonElements.put(getSerializedKey(field), "");
							}
							else {
								jsonElements.put(getSerializedKey(field), field.get(object));
							}	
						}
					}	
				}	
			}
			else {
				jsonElements.put("Unknown element","null");
			}
		}
		catch(IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
		return toJsonString(jsonElements);
	}
	
	private String toJsonString(Map<String, Object> jsonMap) {
        StringBuffer retStr = new StringBuffer();
        for(Entry<String, Object> entry:jsonMap.entrySet()) {
        		retStr.append(entry.getKey()+":"+entry.getValue()+", ");
        }
        retStr = (retStr.length() != 0)?retStr.delete(retStr.length()-2, retStr.length()):new StringBuffer("");
        return "{" + retStr + "}";
    }
	
	private static String getSerializedKey(Field field) {
		String annotationVal = field.getAnnotation(JField.class).value();
		if(annotationVal.isEmpty()) {
			return field.getName();
		}
		else {
			return annotationVal;
		}
	}

	@Override
	public Object toObject(Class<Object> classType, String jsonString) throws JSONSerializationException {
		jVal = new JSONValidator();
		if(jVal.validateJSONBrackets(jsonString)) {
			
		}
		else {
			throw new JSONSerializationException("Invalid json");
		}
		return null;
	}
}
