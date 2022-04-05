package br.com.linux4.integration;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.junit.jupiter.api.Test;

import br.com.linux4.form.AuthForm;
import br.com.linux4.utils.RestAssuredEasy;


public class RestAuthTester extends RestAssuredEasy{
	
	public RestAuthTester() {
		super("auth");
	}
	
	@Test
	void authSuccess() {
		AuthForm form= new AuthForm();
		form.setLogin(user_login);
		form.setPassword(user_password);
		getGiven()
		.contentType(MediaType.APPLICATION_JSON)
		.body(form)
		.accept(MediaType.APPLICATION_JSON)
		.log().all()
		.post("login")
		.then()
		.assertThat()
		.statusCode(Status.OK.getStatusCode());
	}
	@Test
	void authMissingParams() {
		AuthForm form= new AuthForm();
		form.setLogin(user_login);
		getGiven()
		.contentType(MediaType.APPLICATION_JSON)
		.body(form)
		.accept(MediaType.APPLICATION_JSON)
		.log().all()
		.post("login")
		.then()
		.assertThat()
		.statusCode(Status.BAD_REQUEST.getStatusCode());
	}
	
	@Test
	void authNotValidUser() {
		AuthForm form= new AuthForm();
		form.setLogin(user_login);
		form.setPassword("asdasdasd");
		getGiven()
		.contentType(MediaType.APPLICATION_JSON)
		.body(form)
		.accept(MediaType.APPLICATION_JSON)
		.log().all()
		.post("login")
		.then()
		.assertThat()
		.statusCode(Status.BAD_REQUEST.getStatusCode());
	}

}
