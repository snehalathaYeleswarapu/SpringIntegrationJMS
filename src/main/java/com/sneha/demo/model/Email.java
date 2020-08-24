package com.sneha.demo.model;

/**
 * @author Sneha
 *
 */
public class Email {

	private String to;
	private String body;

	public Email() {
		super();
	}

	public Email(String to, String body) {
		super();
		this.to = to;
		this.body = body;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	 @Override
	  public String toString() {
	    return String.format("Email{to=%s, body=%s}", getTo(), getBody());
	  }

}
