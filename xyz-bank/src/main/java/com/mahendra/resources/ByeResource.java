package com.mahendra.resources;

import com.mahendra.models.Message;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/bye-bye")
public class ByeResource {

	public ByeResource() {
	System.out.println("New Instance of ByeBye");
	}
	
	@GET
	public Message bye() {
		Message msg = new Message();
		msg.setSender("Mahendra");
		msg.setText("Good bye!");
		return msg;
	}
	
}
