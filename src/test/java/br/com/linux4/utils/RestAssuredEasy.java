package br.com.linux4.utils;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestAssuredEasy {

	public RestAssuredEasy() {
	}

	public RestAssuredEasy(String route) {
		this.baseUrl += route;
	}

	private String baseUrl = "http://localhost:8080/4linux/";

	protected String user_login = "4linux";
	protected String user_password = "4linux";

	public RequestSpecification getGiven() {
		return given().baseUri(baseUrl);
	}
}
