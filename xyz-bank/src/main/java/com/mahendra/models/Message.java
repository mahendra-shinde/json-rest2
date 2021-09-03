package com.mahendra.models;

import jakarta.xml.bind.annotation.XmlRootElement;

//Enable JAX-B (Java for XML Binding)
@XmlRootElement
public class Message {

	private String text;
	private String sender;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
}
