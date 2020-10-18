package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreateIncidentWithAsset {

	@Test
	public void createIncidentWithoutBody() {
		//Step1: Set the URI / EndPoint
		//ClassName.MethodName or ClassName.VariableName
				RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		//Step2: Authentication (Basic Auth)
				RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
		//Step3: Request Type (Post) + Content type
				Response response = RestAssured
						.given()
						.contentType(ContentType.JSON) // Input format
						.body("{\"short_description\" : \"Post from postPostman\",\"category\" : \"Hardware\"}")
						.post()
						.then()
						.assertThat()
						.statusCode(201)
						.contentType(ContentType.JSON)
						.extract().response();
				
				//Step4: Get Status Code
				System.out.println(response.getStatusCode());
		//Step5: Get Content Type
				System.out.println(response.getContentType());
		//Step6: Get Response Body
				response.prettyPrint();
	}
	
	
}
