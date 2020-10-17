package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncident {

	@Test
	public void getAllIncident() {
		//Step1: Set the URI / EndPoint
		//ClassName.MethodName or ClassName.VariableName
				RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		//Step2: Authentication (Basic Auth)
				RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
		//Step3: Request Type (get)
				Response response = RestAssured.get(); // -> ctrl+2, l
		//Step4: Get Status Code
				System.out.println(response.getStatusCode());
		//Step5: Get Content Type
				System.out.println(response.getContentType());
		//Step6: Get Response Body
				response.prettyPrint();
	}
	
	
}
