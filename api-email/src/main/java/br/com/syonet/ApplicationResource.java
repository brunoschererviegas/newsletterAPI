package br.com.syonet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

	@ApplicationPath(ApplicationResource.PATH)
	public class ApplicationResource extends Application {
	    public static final String PATH = "/api";
}