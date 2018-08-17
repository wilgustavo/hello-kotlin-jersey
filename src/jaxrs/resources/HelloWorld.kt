package jaxrs.resources

import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("hola")
class HelloWorldResource {
	
	@GET
	fun helloWorld() = "Hola Mundo!"
}