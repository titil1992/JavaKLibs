package com.validations;

import java.util.Stack;

import com.exceptions.JSONSerializationException;

public class JSONValidator {
	public boolean validateJSONBrackets(String jsonString) {
		if(jsonString.charAt(0) != '{' || jsonString.charAt(jsonString.length()-1) != '}') {
			return false;
		}
		Stack<Character> st = new Stack<>();
		for (char c:jsonString.toCharArray()) {
			if(c == '{' || c == '(' || c == '[') {
				st.push(c);
			}
			else if(c == ')' || c == '}' || c == ']') {
				if(st.pop() != oppositeOf(c)) {
					return false;
				}
			}
		}
		if(st.empty())
			return true;
		else
			return false;
	}
	private char oppositeOf(char c) {
		if(c == ')') {
			return '(';
		}
		else if(c == ']') {
			return '[';
		}
		else if(c == '}') {
			return '{';
		}
		else {
			return '\0';
		}
	}
	
	private boolean checkJSONFormat(String jsonString) throws JSONSerializationException{
		
		return false;
	}
	
}
