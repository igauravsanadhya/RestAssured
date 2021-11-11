package day1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class CreateUpdateDelete {
	String s;
	@Test(enabled=true,description="to add contacts")
	public void addContact(){
		//using jason object to  store or give data
		//since location and employer are nested we created each object for it
		JSONObject loc=new JSONObject();
		loc.put("city", "Pune");
		loc.put("country", "India");
		
		JSONObject emp=new JSONObject();
		emp.put("jobTitle", "Automation tester");
		emp.put("company", "LTI");
		
		JSONObject body=new JSONObject();
		body.put("firstName", "Gaurav");
		body.put("lastName", "Sharma");
		body.put("email", "gaurav@lntinfotech.com");
		body.put("location", loc);
		body.put("employer", emp);
		
		
		//now send this above data
		
		//aLong with body send above details
		 s=  given()
		    .header("Content-Type","application/json")  //content type is in the header of post man link*/
	        .body(body.toJSONString())  //to convert object in json type
	    .when()
	         .post("http://3.13.86.142:3000/contacts")  // send details to server so that time we use post request
	     .then()
	         .log()
	         .body()
	         .statusCode(200)
	         .extract()  // to extract id
	         .jsonPath()  // from json path
	         .get("_id");
	    System.out.println("id is : " + s);
	
	
	
	}
	
	@Test(enabled=true,dependsOnMethods="addContact",description="to get contacts")
	public void getContact(){
		given()
		.when()
		     .get("http://3.13.86.142:3000/contacts/" + s)
		.then()
		   .log()
		   .body()
		   .statusCode(200);
		
		
		
	}
	
	@Test(enabled=true,dependsOnMethods="getContact",description="to update contacts")
	public void updateContact(){
		//using jason object to  store or give data
		//since location and employer are nested we created each object for it
		JSONObject loc=new JSONObject();
		loc.put("city", "Pune");
		loc.put("country", "India");
		
		JSONObject emp=new JSONObject();
		emp.put("jobTitle", "Mannual tester");
		emp.put("company", "LTI");
		
		JSONObject body=new JSONObject();
		body.put("firstName", "Mohan");
		body.put("lastName", "Malik");
		body.put("email", "mohan@lntinfotech.com");
		body.put("location", loc);
		body.put("employer", emp);
		
		
		//now send this above data
		
		//aLong with body send above details
		 given()
		    .header("Content-Type","application/json")  //content type is in the header of post man link*/
	        .body(body.toJSONString())  //to convert object in json type
	    .when()
	         .put("http://3.13.86.142:3000/contacts/" + s)  // send details to server so that time we use post request
	     .then()
	         .log()
	         .body()
	         .statusCode(204);
	         
	    	
	
	
	}
	
	@Test(enabled=true,dependsOnMethods="updateContact",description="to delete contacts")
	public void deleteContact(){
		given()
		.when()
		     .delete("http://3.13.86.142:3000/contacts/" + s)
		.then()
		   .log()
		   .body()
		   .statusCode(204);
    }
}