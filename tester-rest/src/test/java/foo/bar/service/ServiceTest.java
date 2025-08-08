package foo.bar.service;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import jakarta.ws.rs.core.Response.Status;

import org.junit.jupiter.api.Test;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@QuarkusTest
class ServiceTest {

	@Test
	void testGet() {
		Response response = given()//
				.contentType(ContentType.JSON)//
				.when().get("/")//
				.then()//
				.statusCode(Status.OK.getStatusCode())//
				.extract().response();

		Log.info(response.asString());

		String message = response.jsonPath().getString("test");
		assertNotNull(message);
		assertEquals("Hello World", message);
	}
}