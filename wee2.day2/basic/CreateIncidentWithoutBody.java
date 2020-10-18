package basic;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class CreateIncidentWithoutBody {

	@Test
	public void createIncidentWithoutBody() {
		//Step1: Set the URI / EndPoint
		//ClassName.MethodName or ClassName.VariableName
				RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		//Step2: Authentication (Basic Auth) + Firts Request Password ( Send)
				RestAssured.authentication =  RestAssured.preemptive().basic("admin","Tuna@123");
		//Set File Path for Json
				File jsonfile =new File("CreateIncidentFormat.json");
				
				//Step3: Request Type (Post) + Content type
				Response response = RestAssured
						.given()
						.contentType(ContentType.JSON) 
						.post()
						.then()
						.assertThat()
						.body(JsonSchemaValidator.matchesJsonSchema(jsonfile))
						.extract().response()
						;
				
				//Step4: Get Status Code
				System.out.println(response.getStatusCode());
		//Step5: Get Content Type
				System.out.println(response.getContentType());
		//Step6: Get Response Body
				response.prettyPrint();
	}
	
	
}
