package br.com.linux4.filter;

import java.util.Objects;

import javax.annotation.Priority;
import javax.annotation.security.PermitAll;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resource;

	
	//reference: https://www.appsdeveloperblog.com/token-based-authentication-example/
	@Override
	public void filter(ContainerRequestContext containerRequestContext) {
		final var method = resource.getResourceMethod();
		if (method.isAnnotationPresent(PermitAll.class)) {
			return;
		}
		if (resource.getResourceClass().isAnnotationPresent(PermitAll.class)) {
			return;
		}
		try {
			final String autorizationHeaderContent = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
			if(Objects.isNull(autorizationHeaderContent)) {
				throw new NotAuthorizedException("toket access need to be provided");
			}else if(autorizationHeaderContent.isEmpty() || !autorizationHeaderContent.startsWith("Bearer")){
				throw new NotAuthorizedException("toket access need to be provided");
			}
			else {
				String token = autorizationHeaderContent.substring("Bearer".length()).trim();
				if(token.isEmpty()) {
					throw new NotAuthorizedException("toket access need to be provided");
				}
			}
		} catch (NotAuthorizedException e) {
			this.abort(containerRequestContext);
			return;
		}
		System.out.println("AUTHORIZED");
	}

	private void abort(ContainerRequestContext containerRequestContext) {
		System.out.println("UNAUTHORIZED");
		containerRequestContext.abortWith(Response.status(Status.UNAUTHORIZED).build());
	}
}
