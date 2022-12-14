package api.test;

import static org.hamcrest.Matchers.*;
import java.util.List;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetAPI {

	@Test(enabled = false)
	public void getStatusCode() {
		RestAssured.given().log().all().get("https://api.instantwebtools.net/v1/airlines/2").then().log().all()
				.statusCode(200);
	}

	@Test(enabled = false)
	public void getCallBodyValidation() {
		RestAssured.given().log().all().get("https://api.instantwebtools.net/v1/airlines/2").then().log().all()
				.statusCode(200).body("name", equalTo("Singapore Airlines")).body("country", equalTo("Singapore"))
				.body("slogan", equalTo("A Great Way to Fly")).body("established", equalTo("1947"));
	}

	@Test(enabled = false)
	public void getCallListValidation() {
		String response = RestAssured.given().get("https://api.instantwebtools.net/v1/airlines/2").then().extract()
				.response().asString();
		System.out.println(response);

		JsonPath path = JsonPath.from(response);
		List<String> airlineList = path.getList("name");

		for (String name : airlineList) {
			System.out.println(name);
		}
	}
	
	@Test(enabled = false)
	public void getCallBodyValidation2() {
		RestAssured.given().log().all().get("https://reqres.in/api/unknown/2").then().log().all().statusCode(200)
				.body("name", equalTo("fuchsia rose")).body("year", equalTo("2001")).body("id", equalTo("2"))
				.body("color", equalTo("#C74375"));

	}

}
