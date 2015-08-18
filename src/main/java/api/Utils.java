package api;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Hashtable;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

public class Utils {
	@SuppressWarnings("rawtypes")
	public static String hashtable2json(Hashtable obj) throws IOException {
		Writer writer = new StringWriter();
		JsonGenerator jsonGenerator = new JsonFactory().createJsonGenerator(writer);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(jsonGenerator, obj);
		jsonGenerator.close();
		return writer.toString();
	}

	public static String filepath2filecontent(String filePath) throws IOException, URISyntaxException {
		URL url = RootResource.class.getClassLoader().getResource(filePath);
		byte[] fileContentBytes = Files.readAllBytes(Paths.get(url.toURI()));
		String fileContent = new String(fileContentBytes, StandardCharsets.UTF_8);
		return fileContent;
	}
}
