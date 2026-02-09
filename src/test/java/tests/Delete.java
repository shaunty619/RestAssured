package tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Delete {
	@Test
	public void delete() {
		
		given()
        .pathParam("id", 1)
        .when()
        .delete("https://jsonplaceholder.typicode.com/posts/{id}")
        .then()
        .log()
        .all()
        .statusCode(200);
	}

}
