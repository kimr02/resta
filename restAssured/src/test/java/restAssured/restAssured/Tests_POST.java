package restAssured.restAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*; // can go w/o RestAssured
// must import below so that can do equalTo
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Tests_POST {
	@Test
	public void test_1_post () {
		
		Map <String, Object> map = new HashMap<String, Object> ();
		map.put("\"name\"", "Richard"); // adding ""
		map.put("job", "Teacher");
		
		System.out.println(map);
	}
}
