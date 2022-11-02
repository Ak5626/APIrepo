package apitest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Getres_newmethod {
	
	String baseurl="https://thetestingworldapi.com/";
	String path = "api/studentsDetails/";
	
	@BeforeMethod
	public void precond() {
		RestAssured.baseURI= baseurl;
		RestAssured.basePath=path;
		
	}
	
	@Test
	public void get(){
		Response getres = RestAssured.get();
		System.out.println(getres.getStatusCode());
		System.out.println(getres.asPrettyString());
	}

}
