package chaning;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident extends BaseRequest{

	@Test(dependsOnMethods = "chaning.CreateIncidentWithBody.createIncidentWithoutBody")
	public void deleteIncident() {

		Response response = requestSpecification
				.given()
				.pathParam("ID",sys_id)
				.delete("{ID}");

		//Step4: Get Status Code
		System.out.println(response.getStatusCode());
		//Step5: Get Content Type
		System.out.println(response.getContentType());
		//Step6: Get Response Body
		response.prettyPrint();
	}


}
