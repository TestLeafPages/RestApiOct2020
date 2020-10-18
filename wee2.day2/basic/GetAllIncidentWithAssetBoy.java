package basic;


import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class GetAllIncidentWithAssetBoy {

	@Test
	public void getAllIncident() {
		//Step1: Set the URI / EndPoint
		//ClassName.MethodName or ClassName.VariableName
				RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		//Step2: Authentication (Basic Auth)
				RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
		
				//Map<Key,Value>
				Map<String, String> allParam = new HashMap<String, String>(); 
				allParam.put("sysparm_fields", "sys_id,number,category");
				allParam.put("category", "inquiry");
				allParam.put("sysparm_limit", "2");
				//Step3: Request Type (get)
				Response response = RestAssured
						.given()
						.queryParams(allParam)
						.get()
						.then()
						.assertThat()
						.body("result.number[1]", Matchers.equalTo("INC0000019"))// -> String = EqualTo or ContainString
						.extract()
						.response()
						;
				
		//Step4: Get Status Code
				System.out.println(response.getStatusCode());
		//Step5: Get Content Type
				System.out.println(response.getContentType());
		//Step6: Get Response Body
				response.prettyPrint();
	}
	
	
}
