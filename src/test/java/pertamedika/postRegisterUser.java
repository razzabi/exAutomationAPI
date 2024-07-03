package pertamedika;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class postRegisterUser {

    @Test
    public void postRegisterUser() throws JSONException {
        // Base URI
        RestAssured.baseURI = "https://automationexercise.com";
        Response response = given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("name", "admidelapan")
                .formParam("email", "admidelapan@gmail.com")
                .formParam("password", "password")
                .formParam("firstname", "admin")
                .formParam("lastname", "delapan")
                .formParam("address1", "bugel")
                .formParam("address2", "bugel")
                .formParam("country", "canada")
                .formParam("state", "indonesia")
                .formParam("city", "tangerang")
                .formParam("zipcode", "15113")
                .formParam("mobile_number", "08996999999")
                .formParam("title", "Mr")
                .formParam("birth_date", "20")
                .formParam("birth_month", "November")
                .formParam("birth_year", "1996")
                .formParam("company", "PT ABC")
                .log().all()
                .when()
                .post("/api/createAccount")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();


//this case is additonal case to delete account in API automation after register
        RestAssured.baseURI = "https://automationexercise.com";
        Response response1 = given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("email", "admidelapan@gmail.com")
                .formParam("password", "password")
                .log().all()
                .when()
                .delete("/api/deleteAccount")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is => " + responseBody);
        }
    }


