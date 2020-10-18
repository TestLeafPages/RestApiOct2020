package chaning;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithBody extends BaseRequest{

	@Test
	public void createIncidentWithoutBody() {
		Response response = requestSpecification
				.given()
				.body("{\"short_description\" : \"Post from postPostman\",\"category\" : \"Hardware\"}")
				.post();

		//Step4: Get Status Code
		System.out.println(response.getStatusCode());
		//Step5: Get Content Type
		System.out.println(response.getContentType());
		//Step6: Get Response Body
		response.prettyPrint();
		
		
		JsonPath jsonPath = response.jsonPath();
		sys_id = jsonPath.get("result.sys_id");
		System.out.println(sys_id);
		
		
		
	}


}
