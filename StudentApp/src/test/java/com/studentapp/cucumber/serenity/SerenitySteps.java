package com.studentapp.cucumber.serenity;

import java.util.HashMap;

import com.studentapp.model.AssignmentPojo;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

/**
 * @author mindtree2355
 *
 */
public class SerenitySteps {
	@Step
	public ValidatableResponse createRecord(String name,String job)
	{
		AssignmentPojo a=new AssignmentPojo();
		a.setName(name);
		a.setJob(job);
		return SerenityRest.rest().given().contentType(ContentType.JSON).when().body(a).post().then();
		
	}

//	@Step
//	public HashMap<String,Object> getStudentInfoByFirstName()
//	{
//		HashMap<String,Object> value=SerenityRest.rest().given().when().get().then().log().all().statusCode(200).extract().path(null, null)
//		return null;
//		
//	}

}
