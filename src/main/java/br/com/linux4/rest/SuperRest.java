package br.com.linux4.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

public class SuperRest {

	@Context
	 protected SecurityContext context;
}
