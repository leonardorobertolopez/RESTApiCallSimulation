package com.securid.configuraciones;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/serverapi")
public class ConfiguracionRSA extends ResourceConfig{
    
	public ConfiguracionRSA() {
	    packages("com.securid.serverapi");
	} 
	
	
}
