package br.com.linux4.integration;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.linux4.dto.CategoriesDTO;
import br.com.linux4.dto.EntriesDTO;
import br.com.linux4.exception.BrokenPipeException;
import br.com.linux4.factory.ClientFactory;

public class ApiConsumer {
	
	private String categories = "categories";
	private String entries = "entries";

	public CategoriesDTO getAllCategories() {
		WebTarget target = ClientFactory.getClient();
		
		Response response = target.path(categories)
		.request()
		.accept(MediaType.APPLICATION_JSON)
		.get();
		
		resposeStatusOkValidade(response);
		
		return response.readEntity(CategoriesDTO.class);
	}

	public String getApisListByCategory(String category) {
		WebTarget target = ClientFactory.getClient();
		
		Response response = target.path(entries)
		.request()
		.accept(MediaType.APPLICATION_JSON)
		.get();
		
		resposeStatusOkValidade(response);
		
		return response.readEntity(String.class);
	}

	private void resposeStatusOkValidade(Response response) {
		if(response.getStatus() != Status.OK.getStatusCode())
			throw new BrokenPipeException(response.getStatus());
	}


}
