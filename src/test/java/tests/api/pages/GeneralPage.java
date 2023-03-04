package tests.api.pages;

import io.qameta.allure.Step;
import tests.api.TestDataApi;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.*;

public class GeneralPage extends TestDataApi {

    @Step("Get access token from OAuth2")
    public String getAccessToken(String username, String password, String clientId, String clientSecret) {

        String authToken = given()
                .auth().preemptive().basic(clientId, clientSecret)
                .spec(requestAuth)
                .queryParam("grant_type", "password")
                .queryParam("username", username)
                .queryParam("password", password)
                .when()
                .post("/access_token")
                .then()
                .spec(responseSpec)
                .extract()
                .response()
                .jsonPath().get("access_token");
        return authToken;
    }
}
