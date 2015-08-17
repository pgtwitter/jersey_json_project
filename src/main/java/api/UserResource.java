package api;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Hashtable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

@Path("user")
public class UserResource {
	private static String obj2json(Object obj) throws IOException {
		Writer writer = new StringWriter();
		JsonGenerator jsonGenerator = new JsonFactory().createJsonGenerator(writer);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(jsonGenerator, obj);
		jsonGenerator.close();
		return writer.toString();
	}

	/**
	 * example url "http://localhost:8080/api/user/001"
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String get(@PathParam("id") String id) throws IOException {
		Hashtable<String, Object> data = new Hashtable<String, Object>();
		data.put("name", "foo");
		data.put("type", "bar");
		Hashtable<String, Object> ret = new Hashtable<String, Object>();
		ret.put("id", id);
		ret.put("data", data);
		return obj2json(ret);
	}
}
