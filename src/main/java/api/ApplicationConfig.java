package api;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {
	public ApplicationConfig() {
		packages(this.getClass().getPackage().getName());
	}
}
