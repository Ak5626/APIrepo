package apitest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Postreq {
String endpoint = "https://thetestingworldapi.com/api/studentsDetails/";
	
	@Test
	public void postapi() {
		RequestSpecification Reqspec = RestAssured.given();
		Reqspec.body("{\"id\": 1, \"first_name\": \"AK\", \"middle_name\": \"F\", \"last_name\": \"Deby\", \"date_of_birth\": \"09/09/1977\"}");
        Reqspec.header("content-type", "application/json")	;
        
	     Response postres = Reqspec.post(endpoint);
	   //  System.out.println("Body" + postres.body());
	     System.out.println("status code" + postres.statusCode());
	     System.out.println("Data" + postres.asPrettyString());
	     
	    System.out.println("Firstname" + " " + postres.jsonPath().getString("data.first_name"));
	     //3875212
	}


}
