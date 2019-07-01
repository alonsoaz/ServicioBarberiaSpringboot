package com.barberia.response;

import java.util.ArrayList;
import java.util.List;

public class Responses {

	private static Responses stdregd = null;
	
	private String code;
	private String description;
	
	public Responses(String code) {
		this.code = code;
		this.description = getDescriptionByCode(code);
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String getDescriptionByCode(String code) {
		
		String des = null;
		
		if(code.equals("200")) {
			
			des = "OK";
			
		}else if(code.equals("201")) {
			
			des = "Created";
			
		}
		else if(code.equals("401")) {
			
			des = "Unauthorized";
			
		}
		else if(code.equals("403")) {
			
			des = "Forbidden";
			
		}
		else if(code.equals("404")) {
			
			des = "Not Found";
			
		}
		
		return des;
	}

}
