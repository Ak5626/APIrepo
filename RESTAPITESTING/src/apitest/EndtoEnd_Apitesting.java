package apitest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndtoEnd_Apitesting {
	
	String endpoint = "https://thetestingworldapi.com/api/studentsDetails/";
	String FN = "Term";
	String LN = "yash";
	String MN = "UK";
	String DOB = "05/16/1988";
	String updateMN = "Lo";
	
	
	String postbody = "{\"id\": ID, \"first_name\": \"FNAME\", \"middle_name\": \"MNAME\", \"last_name\": \"LNAME\", \"date_of_birth\": \"DOB\"}";
	
    @Test
	public void postget()
	{
    	//POst details
    	RequestSpecification req = RestAssured.given();
    	
    	req.body(postbody.replace("FNAME", FN).replace("MNAME", MN).replace("LNAME", LN).replace("DOB", DOB).replace("ID", "1"));
        req.header("content-type", "application/json")	;
        
        Response res = req.post(endpoint);
        System.out.println(res.statusCode());
        System.out.println(res.asPrettyString());
        String userid = res.jsonPath().getString("id");
        
     //  Assert.assertEquals(res.statusCode(), 201);
       
       //get details
       Response getres = RestAssured.get(endpoint+userid);
       System.out.println(getres.asPrettyString());
       
       //3875802
       
       //Update details 
       RequestSpecification putreqspec = RestAssured.given();
       putreqspec.body(postbody.replace("FNAME", FN).replace("MNAME", updateMN).replace("LNAME", LN).replace("DOB", DOB).replace("ID", userid));
       putreqspec.header("content-type", "application/json")	;
       
       Response putres = putreqspec.put(endpoint+userid);
       System.out.println(putres.asPrettyString());
       System.out.println(putres.statusCode());
       //Validate put response
       Assert.assertEquals(putres.statusCode(), 200);
		
       //Delete data
       Response deleteres = RestAssured.delete(endpoint+userid);
       System.out.println(deleteres.asPrettyString());
       System.out.println(deleteres.statusCode());
       Assert.assertEquals(deleteres.statusCode(), 200);
	}
}
