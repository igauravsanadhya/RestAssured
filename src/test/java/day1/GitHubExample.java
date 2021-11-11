package day1;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class GitHubExample {
  @Test(enabled = true, description="Getting all reposirtories")
  public void getAllRepos() {
	  given()
	   .auth()
	   .oauth2("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")
	  .when()
	    .get("https://api.github.com/user/repos")	   
	    .then()
	     .log()
	     .body()
	     .statusCode(200)
	     .time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS);
  }
}
