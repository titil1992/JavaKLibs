package com.services.api;

import com.exceptions.JSONSerializationException;

public interface JSONSerializationInterface {
	public String toJson(Object object) throws JSONSerializationException;
	public Object toObject(Class<Object> classType, String jsonString) throws JSONSerializationException;
}
