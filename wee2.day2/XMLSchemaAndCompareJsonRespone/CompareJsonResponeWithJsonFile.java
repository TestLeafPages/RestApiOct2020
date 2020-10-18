package tes;


import java.io.File;
import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class CompareJsonResponeWithJsonFile {

	@Test
	public void getAllIncident() throws JsonProcessingException, IOException {
		//Step1: Set the URI / EndPoint
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident/fb6f7aea2fd3501064df2d6df699b63e";
		//Step2: Authentication (Basic Auth)
		RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
		//Convert File to JsonPath Object
		JsonPath expectedJson = new JsonPath(new File("data.json"));
		
		//Step3: Request Type (get)
		Response response = RestAssured
				.given()
				.get()
				.then()
				.body("", Matchers.equalTo(expectedJson.getMap("")))
				.extract().response();
		//Step4: Get Status Code
		System.out.println(response.getStatusCode());
		//Step5: Get Content Type
		System.out.println(response.getContentType());
		//Step6: Get Response Body
		response.prettyPrint();

	}


}
