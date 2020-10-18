package chaning;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

	public static RequestSpecification requestSpecification;
	public static String sys_id ;
	
	@BeforeSuite
	public void initialize() {
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
		requestSpecification = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON);

	}



}
