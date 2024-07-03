package pertamedika;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getProductslist {

    @Test
    public  void getProductList () throws JSONException {
        // Base URI
        RestAssured.baseURI = "https://automationexercise.com";
        Response response = given()
                .header("Content-Type", "application/json")
                .log().all()
                .when()
                .get("/api/productsList")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is => " + responseBody);
    }
}




