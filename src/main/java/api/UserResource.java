package api;

import java.io.IOException;
import java.util.Hashtable;

import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;

@Path("user")
public class UserResource {
	/**
	 * example url "http://localhost:8080/api/user/001"
	 * 
	 * @param id
	 * @return json string
	 * @throws NoContentException
	 */
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String get(@PathParam("id") String id) throws InternalServerErrorException {
		Hashtable<String, Object> data = new Hashtable<String, Object>();
		data.put("name", "foo");
		data.put("type", "bar");
		Hashtable<String, Object> ret = new Hashtable<String, Object>();
		ret.put("id", id);
		ret.put("data", data);
		try {
			return Utils.hashtable2json(ret);
		} catch (IOException e) {
			throw new InternalServerErrorException(e.getMessage());
		}
	}
}
