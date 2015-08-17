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
	private static String filepath2filecontent(String filePath) throws IOException, URISyntaxException {
		URL url = RootResource.class.getClassLoader().getResource(filePath);
		byte[] fileContentBytes = Files.readAllBytes(Paths.get(url.toURI()));
		String fileContent = new String(fileContentBytes, StandardCharsets.UTF_8);
		return fileContent;
	}

	@Path("/")
	@GET
	@Produces(MediaType.TEXT_HTML + ";charset=utf-8")
	public String get() throws IOException, URISyntaxException {
		return filepath2filecontent("../index.html");
	}
}
