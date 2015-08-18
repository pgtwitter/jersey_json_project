package api;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RootResource {
	@Path("/")
	@GET
	@Produces(MediaType.TEXT_HTML + ";charset=utf-8")
	public String get() throws InternalServerErrorException {
		try {
			return Utils.filepath2filecontent("../index.html");
		} catch (IOException | URISyntaxException e) {
			throw new InternalServerErrorException(e.getMessage());
		}
	}
}
