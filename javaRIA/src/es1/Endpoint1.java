package es1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/es1")
public class Endpoint1 {
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getItems() {
		
		return "Contenuto server side";
	
	}

}
