package apitest;

import java.io.File;
import java.io.FileReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Getres_post_json {
	
	String baseurl="https://thetestingworldapi.com/";
	String path = "api/studentsDetails/";
	
	RequestSpecification reqspec ;
	
	@BeforeMethod
	public void precond() {
		
		File jsonbody = new File("./Requestpayload/Addstud.json");
		
		reqspec = RestAssured.given();
		reqspec.baseUri(baseurl);
		reqspec.basePath(path);
		reqspec.body(jsonbody);
		reqspec.header("content-type", "application/json");	
	
	}
	
	@Test
	public void get(){
		Response putres = reqspec.post();
		System.out.println(putres.getStatusCode());
		System.out.println(putres.asPrettyString());
	}

}
