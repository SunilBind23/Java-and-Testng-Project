package apiTesting;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AgileCrmAutomation {

	public static void main(String[] args) {

		
		int actualStatusCode = res.getStatusCode();
		if (actualStatusCode == 200) {
			System.out.println("pass =>" + actualStatusCode);
		} else {
			System.out.println("fail");
		}
		String responseBody = res.getBody().asPrettyString();
		System.out.println("Response Body: " + responseBody);

		// getting id
		JsonPath jsonPath = res.jsonPath();
		String GetId = jsonPath.getString("id");
		System.out.println("ID: " + GetId);
		jsonPath.getString("");

		
	}

}
