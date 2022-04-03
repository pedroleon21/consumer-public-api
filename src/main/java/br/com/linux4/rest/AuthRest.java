package br.com.linux4.rest;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import br.com.linux4.form.AuthForm;
import br.com.linux4.service.AuthService;

@Path("auth")
@RequestScoped
public class AuthRest extends SuperRest{
	
	AuthService service = new AuthService();
	
	@POST
	@Path("login")
	@PermitAll
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@Valid final AuthForm form) {
		try {
			String token = service.authenticate(form);
			System.out.println("token gerado");
			return Response.ok(token).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
}
