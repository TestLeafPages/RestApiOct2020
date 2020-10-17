package basic;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllIncidentWithXml {

	@Test
	public void getAllIncident() {
		//Step1: Set the URI / EndPoint
		//ClassName.MethodName or ClassName.VariableName
				RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		//Step2: Authentication (Basic Auth)
				RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
		//Step3: Request Type (get)
				Response response = RestAssured
						.given()
//						.accept("application/xml")
						.accept(ContentType.XML)// OutPut Format
						.get();
				
				
		//Step4: Get Status Code
				System.out.println(response.getStatusCode());
		//Step5: Get Content Type
				System.out.println(response.getContentType());
		//Step6: Get Response Body
				//response.prettyPrint();
				
				
//neet to parse Xml
				
				XmlPath xmlResponse = response.xmlPath();
				//get First Sys_id
				List<String> listsysID = xmlResponse.getList("response.result.sys_id");
				
				List<String> number = xmlResponse.getList("response.result.number");
				System.out.println(listsysID.get(0));
				
				
				for (String eachId : listsysID) {
					System.out.println(eachId);
				}
				
					
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	}
	
	
}
