package com.studentapp.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.cucumber.serenity.SerenitySteps;
import com.studentapp.model.AssignmentPojo;
import com.studentapp.testbase.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class AssignmentTest extends TestBase {

	static String name = "Emma";
	static String job = "IncomeTaxOfficer";

	@Steps
	SerenitySteps steps;

	@Title("This will create new user")
	@Test
	public void createNewRecord() {
		AssignmentPojo a = new AssignmentPojo();
		a.setName(name);
		a.setJob(job);

		steps.createRecord(name, job).statusCode(201);
	}

	@Title("This test validates if the response contains given text, Not Found Response")
	@Test
	public void getCountryDetails() {

		RestAssured.baseURI = "https://restcountries.com/v2";

		Response resp = null;
		resp = SerenityRest.rest().given().get("/name/INDIA");
		assertEquals(200, resp.getStatusCode());
		assertTrue(resp.asString().contains("Republic of India"));

		resp = SerenityRest.rest().given().get("/callingcode/xyz");
		assertEquals(404, resp.getStatusCode());
		assertTrue(resp.asString().contains("Not Found"));

	}

	@Title("This test prints all the details Norway and validates its capital")
	@Test
	public void getCapitalDetails() {
		String Country = "Norway";
		RestAssured.baseURI = "https://restcountries.com/v2/name/NORWAY";
		String p1 = "findAll{it.name=='";
		String p2 = "'}.capital";
		String value = SerenityRest.rest().given().get().then().log().all().statusCode(200).extract()
				.path(p1 + Country + p2).toString().replace("[", "").replace("]", "");
		System.out.println("Extracted value is: " + value);
		assertEquals("Oslo", value);

	}
	
	
}
