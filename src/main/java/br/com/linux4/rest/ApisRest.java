package br.com.linux4.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.linux4.dto.CategoriesDTO;
import br.com.linux4.exception.BrokenPipeException;
import br.com.linux4.integration.ApiConsumer;

@Path("apis")
@RequestScoped
public class ApisRest {
	
	
	ApiConsumer consumer = new ApiConsumer(); 
	
	@GET
	@Path("categories")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategories() {
		try {
			CategoriesDTO categorias = consumer.getAllCategories();
			return Response.ok(categorias).build();
		}catch (BrokenPipeException e){
			return Response.status(e.getStatus()).entity("remote service status response").build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
	
	@GET
	@Path("entries")
	public Response getEntriesByCategory(@QueryParam("category") String category) {
		try {
			String entries = consumer.getApisListByCategory(category);
			return Response.ok(entries).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
