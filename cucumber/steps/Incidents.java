package steps;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Incidents {
	
	public RequestSpecification requestSpecification ;
	public Response response;
	
	@Given("set up the endpoint")
	public void setEndPoint() {
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
	}

	@And("set up the Authentication")
	public void setAuthentication() {
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
	}
	
	@And("set the Content Type")
	public void setContentType() {
		requestSpecification = RestAssured.given().contentType(ContentType.JSON);
	}
	
	@When("place the post request")
	public void createIncident() {
		response = requestSpecification.post();
	}
	
	
	
	@When("place the post request as (.*)$")
	public void createIncidentWithBody(String path) {
		File json = new File(path);
		response = requestSpecification
				.body(json)
				.post();
		response.prettyPrint();
	}
	
	@Then("verify the status code as 201")
	public void verifyStatusCode() {
		if (response.getStatusCode() == 201) {
			System.out.println("The status code is 201");
		} else {
			System.out.println("The status code is not 201");
		}
	}
	@And("verify the Content type as json")
	public void verifyContentType() {
		response.then().assertThat().contentType(ContentType.JSON);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
