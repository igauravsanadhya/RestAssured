package day1;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class AddRepo {
	 @Test(enabled = true, description="Adding repository")
  public void AddRepos() {
		 JSONObject js = new JSONObject();
		 js.put("name","RestAssured");
		 js.put("description", "I am created by restAssured");
		 js.put("homepage", "http://github.com/igauravsanadhya");
		 
		 
		   given()
		   .auth()
		   .oauth2("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")
		   .header("Content-Type","application/json")
		   .body(js.toJSONString())
		  .when()
		  .post("https://api.github.com/user/repos")
		   .then()
		     .log()
		     .body()
		     .statusCode(201)
		     .time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS);
		 
  }
}
