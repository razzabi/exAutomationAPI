package pertamedika;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class postVerifyLogin {

    @Test
    public  void postVerifyLogin () throws JSONException {
        // Base URI
        RestAssured.baseURI = "https://automationexercise.com";
        Response response = given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("email", "razabi@test.com")
                .formParam("password", "password")
                .log().all()
                .when()
                .post("/api/verifyLogin")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is => " + responseBody);
    }
}


