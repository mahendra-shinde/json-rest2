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
	
	// New instance for each new request
	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(com.mahendra.resources.ByeResource.class);
		return classes;
	}
	
	// Makes sure SINGLE instance is used for all the request
	// Instance is created as soon as application is deployed
	@Override
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<Object>(); 
		// Register your REST Controllers....
		singletons.add(new HelloResource());
		return singletons;
	}
}
