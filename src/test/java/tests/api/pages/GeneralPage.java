package tests.api.pages;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;
import static tests.api.specs.Spec.request;
import static tests.api.specs.Spec.response;

public class GeneralPage {
    String username = "Alex211621";
    String password = "swimmer88151";
    String clientId = "Du1kpj218PIM_i16bZuoWQ";
    String clientSecret = "WI0dNXFzCQ0jB7a6onK0WXWiP7NUEg";

    @Step("Get access token from OAuth2")
    public String getAccessToken(String username, String password, String clientId, String clientSecret) {

        String authToken = given()
                .auth().preemptive().basic(clientId, clientSecret)
                .spec(request)
                .queryParam("grant_type", "password")
                .queryParam("username", username)
                .queryParam("password", password)
                .when()
                .post("https://www.reddit.com/api/v1/access_token")
                .then()
                .spec(response)
                .extract()
                .response()
                .jsonPath().get("access_token");
        return authToken;
    }

    public String createPostAndGetThingId() {
        String thing_id = given()
                .auth().preemptive().oauth2(getAccessToken(username, password, clientId, clientSecret))
                .spec(request)
                .formParam("sr", "u_" + username.toLowerCase())
                .formParam("api_type", "json")
                .formParam("title", "The authorization header will b")
                .formParam("kind", "self")
                .formParam("richtext_json", "{\"document\":[{\"e\":\"par\",\"c\":[{\"e\":\"text\",\"t\":\"The authorization header will be automatically generated when you send the request. Learn more about authorization\"}]}]}")
                .post("https://oauth.reddit.com/api/submit")
                .then()
                .spec(response)
                .extract()
                .response()
                .jsonPath().get("json.data.name");;
        return thing_id;
    }
}
