package org.redhat;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {


    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }
    @Test
    public void getAll() {
        given()
                .when().get("/tdd")
                .then()
                .statusCode(200)
                .body(
                        "$.size()", is(1),
                        "[0].id", is(1),
                        "[0].message", is("Hello")
                );
    }

    @Test
    public void getOneFound() {
        given()
                .when().get("/tdd/1")
                .then()
                .statusCode(200)
                .body(
                        "id", is(1),
                        "message", is("Hello")
                );
    }

    @Test
    public void getOneNotFound() {
        given()
                .when().get("/tdd/2")
                .then().statusCode(404);
    }

}