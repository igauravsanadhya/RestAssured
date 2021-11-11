package day1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class AddContact {
  @Test(enabled= false, description = "Adding Contact")
  public void addContact() {
	  JSONObject loc = new JSONObject();
	  loc.put("city", "Pune");
	  loc.put("country", "India");
	  
	  JSONObject emp = new JSONObject();
	  emp.put("jobTitle", "Automation Tester");
	  emp.put("company", "LTI");
	  JSONObject ob = new JSONObject();
	  ob.put("firstName", "Amy");
	  ob.put("lastName", "Smith");
	  ob.put("email", "asmith@thinkingtester.com");
	  ob.put("location", loc);
	  ob.put("employer", emp);
	  
	  String id = given()
			  .header("Content-Type","application/json")
			  .body(ob.toJSONString())
           .when()
           .post("http://3.13.86.142:3000/contacts")
           .then()
           .log()
           .body()
           .statusCode(200)
           .extract()
           .jsonPath()
           .get("_id");
	  System.out.println("The ID is "+id);
  }
	  
    @Test(enabled= true, description= "Get Contact")
    public void f() {
    	given()
   	  .when()
   	  .get("http://3.13.86.142:3000/contacts/618a3cd0f2967f0ec893ec6e")
   	  .then()
   	  .log()
   	  .body()
   	  .statusCode(200); 
}
	
  }

