package restAssured.restAssured;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*; // can go w/o RestAssured
// must import below so that can do equalTo
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test01_Example {
	
	
	//@Test
	void test_get () {
		baseURI = "http://localhost:3000/";
		
		
		given().
			header("Content-Type","application/JSON").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			param("name","Automation").
			get("/subjects").
		then().
			statusCode(200).
			log().all();
		
	}
	
	//@Test
	void test_post () {
		baseURI = "http://localhost:3000/";
		JSONObject request = new JSONObject ();
		
		request.put("firstname","Jim");
		request.put("lastname","Thomas");
		request.put("subjectId",1);
		request.put("id",4);
		
		baseURI = "http://localhost:3000/";
		given().
			header("Content-Type","application/JSON").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		
	}
	
	//@Test
	void test_patch () {
		baseURI = "http://localhost:3000/";
		JSONObject request = new JSONObject ();
		
		request.put("firstname","UPDATE");
		
		baseURI = "http://localhost:3000/";
		given().
			header("Content-Type","application/JSON").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/4"). // id has to specify
		then().
			statusCode(200).
			log().all();
		
	}
	
	//@Test
	void test_put () {
		baseURI = "http://localhost:3000/";
		JSONObject request = new JSONObject ();
		
		request.put("firstname","MARY");
		request.put("lastname","Maryson");
		request.put("subjectId",1);
		
		baseURI = "http://localhost:3000/";
		given().
			header("Content-Type","application/JSON").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/4"). // id has to specify
		then().
			statusCode(200).
			log().all();
		
	}
	
	//@Test
	void test_delete () {
		baseURI = "http://localhost:3000/";

		when().
			delete("users/4"). // id has to specify
		then().
			statusCode(404).
			log().all();
		
	
		
	}
	
	@Test (dataProvider = "SearchProvider")
	void testMethod (String firstname, String lastname, int id) {
		
		System.out.println("FName: " +firstname + " LName: " + lastname + " ID : " +id);
		
	}
	@DataProvider(name = "SearchProvider")
	public Object [][] getDataFromDataProvider () {

		/*
		Object [][] data = new Object[2][3];
		
		data[0][0] = "Richard";
		data[0][1] = "kim";
		data[0][2] = "1";
	
		data[1][0] = "Alex";
		data[1][1] = "kim";
		data[1][2] = "2";
		*/
		return new Object[][]
		 {
			{"Richard","Kim",1},
			{"alex","Kim",2}
		 };
	
	}
	
	
	
}
