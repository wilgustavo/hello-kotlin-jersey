import jaxrs.Application
import javax.ws.rs.core.UriBuilder
import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider

fun main(args: Array<String>) {
	
	val url = UriBuilder.fromUri("http://0.0.0.0/").port(8080).build()
	
	//val httpServer = GrizzlyHttpServerFactory.createHttpServer(url, Application(), true)
	val httpServer = NettyHttpContainerProvider.createHttp2Server(url, Application(), null)
	
	
    if (System.getenv()["SHUTDOWN_TYPE"].equals("INPUT")) {
        println("Press any key to shutdown")
        readLine()
        println("Shutting down from input")
        httpServer.close()
    } else {
        Runtime.getRuntime().addShutdownHook(Thread {
            println("Shutting down from shutdown hook")
            httpServer.close()
        })

        println("Press Ctrl+C to shutdown")
        Thread.currentThread().join()
    }
	
}
