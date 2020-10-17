package basic;

import java.io.File;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithFileDP {
	
	
	@DataProvider(name = "fetchData")
	public String[] getData() {
								// Row // Column
//		String[][] data = new String[2][1];
		String[] data = new String[2];
		// 1st Row -> file 1
		data[0] = "./data/CreateIncident1.json";
		// 2ns Row -> file 2
		data[1] = "./data/CreateIncident2.json";
		return data;
	}

	@Test(dataProvider = "fetchData")
	public void createIncidentWithoutBody(String filePath) {
		//Step1: Set the URI / EndPoint
		//ClassName.MethodName or ClassName.VariableName
				RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		//Step2: Authentication (Basic Auth)
				RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
		//Step3: Request Type (Post) + Content type
				
				//set Json file Path
				File file = new File(filePath);
				
				Response response = RestAssured
						.given()
						.contentType(ContentType.JSON) // Input format
						.body(file)
						.post();
				
				//Step4: Get Status Code
				System.out.println(response.getStatusCode());
		//Step5: Get Content Type
				System.out.println(response.getContentType());
		//Step6: Get Response Body
				response.prettyPrint();
	}
	
	
}
