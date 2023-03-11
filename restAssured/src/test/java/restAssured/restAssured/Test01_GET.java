package restAssured.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*; // can go w/o RestAssured
// must import below so that can do equalTo
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class Test01_GET {
	
	@Test
	void test_01 () {
		
		//Response response = RestAssured.get("https://reqres.in/api/users/2");
		Response response = get("https://reqres.in/api/users/2");
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println("statuscode = :" + response.getStatusCode());
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
	}
	
	@Test
	void test_02 () {
		// can simplify like below code after static resAssure .* class imported
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);

	}
	
	@Test
	void test_03 () {
		// body("", equalTo)
		
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)  // check pont 1
			.body("data.id[0]", equalTo(7)); // see above import TWO mathods statically 

		
	}
	
	@Test
	void test_04 () {
		// body ("", hasItems ("",""))
		
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[0]", equalTo(7))
			.body("data.first_name", hasItems("Michael","Lindsay"));
		
	}
	
}
