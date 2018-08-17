package jaxrs.resources

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("hola")
class HelloWorldResource {
	
	@GET
	fun helloWorld() = "Hola Mundo!"
	
	data class HelloJson(val id: Int, val name: String)
	
	@GET
	@Path("json")
	@Produces(MediaType.APPLICATION_JSON)
	fun helloJson() = HelloJson(1, "test")
	
}