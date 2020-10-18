package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIncident {

	@Test
	public void updateIncident() {
		//Step1: Set the URI / EndPoint
		//ClassName.MethodName or ClassName.VariableName
				RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident/";
		//Step2: Authentication (Basic Auth)
				RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
		//Step3: Request Type ()
				Response response = RestAssured
						.given()
						.queryParam("sysparm_fields", "sys_id,number,category,short_description")
						.log()
						.all()
						.contentType(ContentType.JSON)
						.pathParam("sys_ID", "9d3c1197c611228701cd1d94bc32d76d")
						.body("{\"short_description\" : \"update desc using patch\",\"state\" : \"2\"}")
						.patch("{sys_ID}");
		//Step4: Get Status Code
				System.out.println(response.getStatusCode());
		//Step5: Get Content Type
				System.out.println(response.getContentType());
		//Step6: Get Response Body
				response.prettyPrint();
	}
	
	
}
