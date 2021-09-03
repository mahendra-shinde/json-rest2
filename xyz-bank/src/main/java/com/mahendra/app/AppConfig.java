package com.mahendra.app;

import java.util.HashSet;
import java.util.Set;

import com.mahendra.resources.HelloResource;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class AppConfig extends Application {
	
	public AppConfig() {
		
	}
	
	@Override
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<Object>(); 
		// Register your REST Controllers....
		singletons.add(new HelloResource());
		return singletons;
	}
}
