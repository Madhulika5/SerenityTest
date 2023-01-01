package com.studentapp.junit;



import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {
public Response resp;
	@BeforeClass
	public static void init() {
	 RestAssured.baseURI="https://restcountries.com/v2";
		//RestAssured.baseURI = "https://petstore.swagger.io";
	}

	/**
	 * 
	 */
	@Test
	public void getCountryName() {
		
  SerenityRest.given().get("/name/INDIA").then().log().all().statusCode(200).toString();
	
	
//		assertTrue(r.contains("Republic of India"));
////		;
	}

}
