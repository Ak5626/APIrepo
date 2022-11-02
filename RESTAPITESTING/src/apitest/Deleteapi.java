package apitest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Deleteapi {
	
	String endpoint = "https://thetestingworldapi.com/api/studentsDetails/3875212";
	
	@Test
	public void deletea() {
		
		Response res = delete(endpoint);
		
		System.out.println(res.getStatusCode());
		
		
		
	}

}
