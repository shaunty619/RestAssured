package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import demo.Product;

public class PostTest1 {

    @Test
    public void createNewProduct() {

        Product product = new Product(101,"HP","hp dsesc",1);
       

     
        given()
        .header("Content-Type", "application/json")
        .body(product)
        .when()
        .post("https://jsonplaceholder.typicode.com/posts")
        .then()
        .log().all()
        .assertThat()
        .statusCode(201)
        .body("id", equalTo(product.getId()));
            

    }
}