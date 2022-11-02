package apitest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Postreq_BDD {
	String endpoint = "https://thetestingworldapi.com/api/studentsDetails/";
	
	
	@Test
	public void post()
	{
		
	given()
	     .contentType(ContentType.JSON)
		 .body("{\"id\": 1, \"first_name\": \"AK\", \"middle_name\": \"F\", \"last_name\": \"Deby\", \"date_of_birth\": \"09/09/1977\"}")
        
    .when()
    
        .post(endpoint)
       // .asPrettyString();
    
     .then()
     .statusCode(201);
    
   
        
      //  System.out.println();
        
	   
	   
	}

}
