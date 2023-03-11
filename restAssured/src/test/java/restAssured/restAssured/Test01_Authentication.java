package restAssured.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*; // can go w/o RestAssured
// must import below so that can do equalTo
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test01_Authentication {
	

	@Test
	void authenticationTest() {
		RestAssured.baseURI = "https://api-m.sandbox.paypal.com";
		RequestSpecification request = RestAssured.given();
		
		String credentials = "AWJ_qTbfVx4wrqlCsHoxMtFRRfnes-rgKmd0FO1YpezzRKme61layuITtRlPo-hhv4BXOx2-i-gDQkC5:EAIyrT7uSUQFEnZd_Ex0bALT-tdd4iOYk9ZzspruFJP8wVGnxtBcc8yCcamGzJpi7nru-a9RyHgsy0S2"; 
		
		Base64.encodeBase64(credentials.getBytes());
		
		byte[] encodeCredentials = Base64.encodeBase64(credentials.getBytes());
		String encodeCredentialsAsString = new String (encodeCredentials);
		request.header("Authorization", "Basic" +encodeCredentialsAsString);
			
	}
}
