package com.springboot.jwt.domain;

import java.io.Serializable;

public class Response implements Serializable{
	
	
	private static final long serialVersionUID = 3733837287429550908L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Response(String message) {
		super();
		this.message = message;
	}
	
	

}
