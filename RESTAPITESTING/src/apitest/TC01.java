package apitest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC01 {
	
	String endpoint = "https://thetestingworldapi.com/api/studentsDetails/3875212";
	
	@Test
	public void testgetapi() {
		
	     Response getres = RestAssured.get(endpoint);
	     System.out.println("Body" + getres.body());
	     System.out.println("status code" + getres.getStatusCode());
	     System.out.println("Data" + getres.asPrettyString());
	     
	     System.out.println("Firstname" + " " + getres.jsonPath().getString("data.first_name"));
	}

}
