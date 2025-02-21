import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AgileCrmAutomation {

	public static void main(String[] args) {

		String contentType = "application/json";
		String UserName = "bindsunil9336@agilecrm.com";
		String Password = "sunil@2004";
		String URL = "https://sunil23.agilecrm.com/dev/api/contacts"; // get Contact url

		Response res = RestAssured.given().contentType(contentType).accept(contentType).auth().basic(UserName, Password)
				.get(URL); // get---post---put---delete

//		Response res2 = RestAssured.given().contentType(contentType).accept(contentType).auth()
//				.basic(UserName, Password).body("need for json object").post(URL);
//		

		int actualStatusCode = res.getStatusCode();
		if (actualStatusCode == 200) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		String jsonResStr = res.getBody().asPrettyString();
		JSONObject js = new JSONObject(jsonResStr);
		String value = js.getString("star_value"); // key

		JSONArray jsonArr = js.getJSONArray("properties");
		JSONObject js2 = jsonArr.getJSONObject(1);
		String actualValue = js2.getString("value");
	}

}
