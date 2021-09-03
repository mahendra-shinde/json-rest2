package com.mahendra.resources;

import java.util.*;

import com.mahendra.models.Account;

import jakarta.ws.rs.*;

@Path("/accounts")
public class AccountResource {

	private List<Account> accounts = new LinkedList<>();
	
	public AccountResource() {
		accounts.add(new Account("Nirav",230000.0, "12300888"));
		accounts.add(new Account("Vijay",780000.0, "13100889"));
	}
	
	@GET
	public List<Account> findAll(){
		// Return a Readonly list
		return Collections.unmodifiableList(accounts);
	}
	
	@PUT
	@Consumes("application/json")
	public Account update(Account acc) {
		Optional<Account> temp = accounts.stream().filter(x -> x.getAccNumber().equals(acc.getAccNumber())).findFirst();
		if(temp.isPresent()) {
			Account acc1 = temp.get();
			acc1.setAccHolderName(acc.getAccHolderName());
			acc1.setBalance(acc.getBalance());
			return acc1;
		}
		return null;
	}
	
	@POST
	@Consumes("application/json")
	public Account create(Account acc) {
		accounts.add(acc);
		return acc;
	}
	
	@DELETE
	public String deleteByNumber(@QueryParam("accno") String accno ) {
		Optional<Account> temp = accounts.stream().filter(x -> x.getAccNumber().equals(accno)).findFirst();
		if(temp.isPresent()) {
			Account acc1 = temp.get();
			accounts.remove(acc1);
			return "Record Deleted";
		}
		else return "Record not found";
	}
}
