package day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class OpenWeatherAPI {
  @Test
  public void getWeatherInfo() {
	  RestAssured.given()
	  .when()
	  .get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=c8479f8b499f0beeb8982685ccdf6fea")
	  .then()
	  .log()
	  .body()
	  .statusCode(200);
  }
}
