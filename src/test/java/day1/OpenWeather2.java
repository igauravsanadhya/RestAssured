package day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OpenWeather2 {
  @Test(enabled=false,description="getting weather app info generally")
  public void GetWeatherinfo() {
	  /*  given> pre comdition   like comtent type,authentication
	   when> user performs something
	   then>*/
	  
	  
	  
	  RestAssured.given()
	  .when()
	  .get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=82a66849b9c3d7d9746d0a2565fbb1f0")
	  .then()
	  .log()
	  .body()
	  .statusCode(200);//log(print) onto body as we want content of body not head
 }
 //if enabled set to true then only that will rum and not any other
 @Test(enabled=false,description="getting weather app info generally")
 public void getWeatherInfo2() {
	 
	  Response res=RestAssured.given()
	  .when()
	  .get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=c8479f8b499f0beeb8982685ccdf6fea");
	  System.out.println(res.prettyPrint());
	  System.out.println(res.getTime());
	  System.out.println(res.getStatusCode());
	  System.out.println(res.getContentType());
	 
 }
 
 
 
 @Test(enabled=true,description="getting weather app info generally")
 public void getWeatherInfo3() {
	 Map<String, String> param= new HashMap<String,String>();
	 param.put("q", "Mumbai");
	 param.put("appid", "c8479f8b499f0beeb8982685ccdf6fea");
	 
     RestAssured.given()
//     .queryParam("q", "Mumbai")
//     .queryParam("appid", "c8479f8b499f0beeb8982685ccdf6fea")
       .formParams(param)
	  .when()
	  .get("http://api.openweathermap.org/data/2.5/weather")
     .then()
     .log().body().statusCode(200);
	
  }
}
