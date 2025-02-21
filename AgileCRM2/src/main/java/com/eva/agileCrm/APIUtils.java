package com.eva.agileCrm;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIUtils {
	private String contentType = "application/json";
	private String UserName = "bindsunil9336@agilecrm.com";
	private String Password = "sunil@2004";
	private String URL = "https://sunil23.agilecrm.com/";

	public Response getRequest(String endPoint) {

		Response response = RestAssured.given().accept(contentType).auth().basic(UserName, Password)
				.get(URL + endPoint);
		return response;
	}

	public Response postRequest(String endPoint, String json) {
		Response response = RestAssured.given().contentType(contentType).accept(contentType).auth()
				.basic(UserName, Password).body(json).post(URL);

		return response;
	}

	public Response putRequest(String endPoint, String json) {
		Response response = RestAssured.given().contentType(contentType).accept(contentType).auth()
				.basic(UserName, Password).body(json).put(URL);

		return response;
	}

	public Response deleteRequest(String endPoint, String json) {
		Response response = RestAssured.given().accept(contentType).auth().basic(UserName, Password).delete(URL);

		return response;
	}
}
