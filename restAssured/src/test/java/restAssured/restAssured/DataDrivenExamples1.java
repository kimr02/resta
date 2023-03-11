package restAssured.restAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExamples1 extends DataForTest{

//	@DataProvider(name = "DataForPost")
//	public Object[][] dataForPost () {
//		
//		Object[][] data = new Object[2][3];
//		
////		data[0][1] = "albert";
////		data[0][2] = "Johnson";
////		data[0][3] = 2;
////		
////		data[1][1] = "alex";
////		data[1][2] = "Kim";
////		data[1][3] = 3;
////		
////		return data;
//		
//		return new Object[][] {
//			{"Alex","Kim", 1},
//			{"Robert","Kiyoski",2},
//			{"Tom","Test",3}
//			
//		};
//	}
	
	//@Test(dataProvider="DataForPost")
	public void test_post (String firsName, String lastName, int subjectId) {
		baseURI = "http://localhost:3000/";
		JSONObject request = new JSONObject ();
		
		request.put("firstname",firsName);
		request.put("lastname",lastName);
		request.put("subjectId",subjectId);

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
	
	
	//@Test(dataProvider = "DataForTest")
	@Test
	@Parameters ({"userId", "firstName","lastName"})
	public void test_param (String userId, String firstName, String lastName) {
		
		System.out.println("userID: "+userId);
		System.out.println("First Name = " +firstName);
		System.out.println("LAst Name = "+lastName);
	}

}
