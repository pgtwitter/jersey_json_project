package api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RootResource {
	@Path("/")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String get() throws IOException, URISyntaxException {
		URL url = RootResource.class.getClassLoader().getResource("../index.html");
		byte[] fileContentBytes = Files.readAllBytes(Paths.get(url.toURI()));
		String fileContent = new String(fileContentBytes, StandardCharsets.UTF_8);
		return fileContent;
	}
}
