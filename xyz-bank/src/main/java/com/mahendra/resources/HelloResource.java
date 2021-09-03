package com.mahendra.resources;

import com.mahendra.models.Message;

import jakarta.ws.rs.*;

@Path("/hello")
public class HelloResource {
	
	public HelloResource() {
		System.out.println("Creating an instance");
	}

	@GET 
	public Message sayHello() {
		Message msg = new Message();
		msg.setSender("Mahendra Shinde");
		msg.setText("Hello India");
		return msg;
	}
	
	@GET 
	@Produces("text/plain")
	public String sayHelloInText() {
		return "Sender: Mahendra Shinde \nText: Hello India";
	}
	
	@GET 
	@Produces("text/html")
	public String sayHelloInHTML() {
		return "<table border=1 cellpadding=3><tr><td>Sender</td><td>Mahendra Shinde </td></tr>"+
				"<tr><td>Text</td><td> Hello India</td><tr></table>";
	}
	
	
}
