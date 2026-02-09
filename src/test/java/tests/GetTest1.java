package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class GetTest1 {

    @Test
    public void getSingleProduct() {

        given()
        .pathParam("id", 1)
        .when()
            .get("https://jsonplaceholder.typicode.com/posts/{id}")
        .then()
            .log().all()
            .statusCode(200)
            .body("id", equalTo(1));
    }
}


