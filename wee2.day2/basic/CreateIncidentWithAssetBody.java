package basic;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithAssetBody {

	@Test
	public void createIncidentWithoutBody() {
		//Step1: Set the URI / EndPoint
		//ClassName.MethodName or ClassName.VariableName
				RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		//Step2: Authentication (Basic Auth)
//				RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
				
				RestAssured.authentication  = RestAssured.oauth2("plDB1_5jczNvZ9wEmfKM5go3ceA6z5vYAFjXOZQ5R3uCbb_rLYhg3ivg-JOKbbaUdt_blFbo28TiTsOPEQw_6Q");
		//Step3: Request Type (Post) + Content type
				Response response = RestAssured
						.given()
						.contentType(ContentType.JSON) // Input format
						.body("{\"short_description\" : \"Post from Rest Assured\",\"category\" : \"Hardware\"}")
						.post()
						.then()
						.assertThat()
						//Path , Value
						//.body("result.short_description", Matchers.equalTo("Post from Rest Assured"))
						.body("result.short_description", Matchers.containsString("Rest Assured1"))
						
						.statusCode(201)
						.extract().response();
				
				//Step4: Get Status Code
				System.out.println(response.getStatusCode());
		//Step5: Get Content Type
				System.out.println(response.getContentType());
		//Step6: Get Response Body
				response.prettyPrint();
	}
	
	
}
