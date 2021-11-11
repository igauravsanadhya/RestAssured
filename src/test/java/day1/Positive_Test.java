package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Positive_Test {
  @Test(enabled= true, description=" For getting all contact List")
  public void getAllContactList() {
	  given()
	  .when()
	  .get("http://3.13.86.142:3000/contacts")
	  .then()
	  .log()
	  .body()
	  .statusCode(200);
  }
}
