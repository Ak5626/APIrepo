package apitest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class putreq {
	
	@Test
	public void putreq() {
		String endpoint = "https://thetestingworldapi.com/api/studentsDetails/3875212";
		
		
			RequestSpecification putspec = RestAssured.given();
			putspec.body("{\"id\": 3875212, \"first_name\": \"AP \", \"middle_name\": \"F\", \"last_name\": \"Deb\", \"date_of_birth\": \"09/09/1977\"}");
	        putspec.header("content-type", "application/json")	;
	        
		     Response putres = putspec.put(endpoint);
		   //  System.out.println("Body" + postres.body());
		     System.out.println("status code" + putres.statusCode());
		     System.out.println("Data" + putres.asPrettyString());
		     
		    System.out.println("Firstname" + " " + putres.jsonPath().getString("data.first_name"));
		     //3875212
		

	}

}
