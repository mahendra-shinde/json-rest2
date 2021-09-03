package com.mahendra.resources;

import java.util.*;

import com.mahendra.models.Account;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/accounts")
@Produces({"application/json","application/xml"})
public class AccountResource {

	private List<Account> accounts = new LinkedList<>();
	
	public AccountResource() {
		accounts.add(new Account("Nirav",230000.0, "12300888"));
		accounts.add(new Account("Vijay",780000.0, "13100889"));
	}
	
	@GET
	public Response findAll(){
		// Return a Readonly list
		List<Account> accList =  Collections.unmodifiableList(accounts);
		return Response.ok(accList).build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response update(Account acc) {
		Optional<Account> temp = accounts.stream().filter(x -> x.getAccNumber().equals(acc.getAccNumber())).findFirst();
		if(temp.isPresent()) {
			Account acc1 = temp.get();
			acc1.setAccHolderName(acc.getAccHolderName());
			acc1.setBalance(acc.getBalance());
			// Return HTTP Status 200 / OK
			return Response.ok(acc1).build();
		}
		return Response.notModified("Record not found!").build();
	}
	
	@POST
	@Consumes("application/json")
	public Response create(Account acc) {
		accounts.add(acc);
		return Response.ok(acc).build();
	}
	
	@DELETE
	@Produces("text/plain")
	public Response deleteByNumber(@QueryParam("accno") String accno ) {
		Optional<Account> temp = accounts.stream().filter(x -> x.getAccNumber().equals(accno)).findFirst();
		if(temp.isPresent()) {
			Account acc1 = temp.get();
			accounts.remove(acc1);
			return Response.ok("Record deleted successfuly").build();
		}
		else return Response.status(404).entity("Record not found").header("Redirect", "http://.....").build();
	}
}
