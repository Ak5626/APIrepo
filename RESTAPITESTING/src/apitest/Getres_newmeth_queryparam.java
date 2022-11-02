package apitest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Getres_newmeth_queryparam {
	
	String baseurl="https://reqres.in/";
	String path = "api/users/";
	
	RequestSpecification getreq ;
	@BeforeMethod
	public void precond() {
		getreq = RestAssured.given();
		getreq.baseUri(baseurl);
		getreq.basePath(path);
		getreq.queryParam("page", "2");
		
		System.out.println(getreq.log().all());
		
	}
	
	@Test
	public void get(){
		Response getres = getreq.get();
		System.out.println(getres.getStatusCode());
		System.out.println(getres.asPrettyString());
	}

}


