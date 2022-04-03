package br.com.linux4.factory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.ClientConfig;

public class ClientFactory {
	
	static private String baseRoute= "https://api.publicapis.org/";

	public static WebTarget getClient() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		return client.target(baseRoute);
	}

}
