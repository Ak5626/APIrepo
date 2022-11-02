package apitest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Getres_post_json_newmeth {
	
	String baseurl="https://thetestingworldapi.com/";
	String path = "api/studentsDetails/";
	
	RequestSpecification reqspec ;
	
	@BeforeMethod
	public void precond() throws IOException{
		String a ="";
		
		File f = new File("./Requestpayload/Addstud.json");
		FileReader fr = new FileReader(f);
		BufferedReader br= new BufferedReader(fr);
		
		String jsoncontent = br.readLine();
		
		while(jsoncontent != null){
		a= a + jsoncontent;
		jsoncontent = br.readLine();
		}
		
		reqspec = RestAssured.given();
		reqspec.baseUri(baseurl);
		reqspec.basePath(path);
		reqspec.body(a);
		reqspec.header("content-type", "application/json");	
	    System.out.println(reqspec.log().all());
	}
	
	

	@Test
	public void get(){
		Response putres = reqspec.post();
		System.out.println(putres.getStatusCode());
		System.out.println(putres.asPrettyString());
	}

}
