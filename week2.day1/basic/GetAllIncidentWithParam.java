package basic;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidentWithParam {

	@Test
	public void getAllIncidentWithParam() {
		//Step1: Set the URI / EndPoint
		//ClassName.MethodName or ClassName.VariableName
				RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		//Step2: Authentication (Basic Auth)
				RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
				//Map<Key,Value>
				Map<String, String> allParam = new HashMap<String, String>(); 
				allParam.put("sysparm_fields", "sys_id,number,category");
				allParam.put("category", "inquiry");
//				allParam.put("sysparm_limit", "1");
				
				
		//Step3: Request Type (get) + Query Param 
				Response response = RestAssured
						.given()
						//Key -> Value
						.queryParams(allParam)
						.get(); 
						
				//Step4: Get Status Code
				System.out.println(response.getStatusCode());
		//Step5: Get Content Type
				System.out.println(response.getContentType());
		//Step6: Get Response Body
				response.prettyPrint();
	}
	
	
	
	
	
	
	/*Response response = RestAssured
			.given()
			//Key -> Value
			.queryParam("sysparm_fields","sys_id,number,category")
			.queryParam("category", "inquiry")
			.queryParam("sysparm_limit", "1")
			.get(); 
*/	
	
	
	
}
