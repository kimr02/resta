package restAssured.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*; // can go w/o RestAssured
// must import below so that can do equalTo
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test01_POST {
	
	
	//@Test
	void test_post1 () {
		// json simple to add into POM xml
		
		//data
		/*
		 * /api/users
		{
    		"name": "morpheus",
    		"job": "leader"
		}
		 */
		
		JSONObject request = new JSONObject();
		request.put("name","Richard");
		request.put("job","Teacher");
//		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type","application/JSON").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201);
		
	}
	
	//@Test
	void test_put1 () {
		
		// log.all()
		
		JSONObject request = new JSONObject(); // can run without map 
		request.put("name","Richard");
		request.put("job","Teacher");
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type","application/JSON").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString())
		.when()
			.put("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test
	void test_delete1 () {
		

		when()
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(204)
			.log().all();
		
	}
	
}
