package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;


import demo.Product;
import io.restassured.RestAssured;

public class Put {
	    @Test
    public void updateProduct(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Product product = new Product(
                1,
                "HP",
                "HP  description",
                1
        );
        given()
                .header("Content-Type", "application/json")
                .pathParam("id", 1)
                .body(product)
                .when()
                .put("/posts/{id}")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("title", equalTo("HP"))
                .body(matchesJsonSchemaInClasspath("schema.json"));
    }

}
