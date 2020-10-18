package tes;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.io.File;
import java.io.InputStream;
public class GetAllIncidentWithXMLSchema {

	@Test
	public void getAllIncidentWithXMLSchema() {
		//Step1: Set the URI / EndPoint
		//ClassName.MethodName or ClassName.VariableName
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident/fb6f7aea2fd3501064df2d6df699b63e";
		//Step2: Authentication (Basic Auth)
		RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
		//Step3: Request Type (get)
		Response response = RestAssured
				.given()
				.accept(ContentType.XML)
				.get()
				.then()
				.body(matchesXsd(new File("sample.xsd")))
				.extract().response(); // -> ctrl+2, l
		//Step4: Get Status Code
		System.out.println(response.getStatusCode());
		//Step5: Get Content Type
		System.out.println(response.getContentType());
		//Step6: Get Response Body
		response.prettyPrint();
	}


}
