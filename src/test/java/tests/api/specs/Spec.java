package tests.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static tests.api.supportApi.CustomApiListener.withCustomTemplates;

public class Spec {
    public static RequestSpecification requestAuth = with()
            .log().all()
            .baseUri("https://www.reddit.com/api/v1")
            .filter(withCustomTemplates())
            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .header("User-Agent", "MockClient/0.1 by Me");
    public static RequestSpecification request = with()
            .log().all()
            .baseUri("https://oauth.reddit.com/api")
            .filter(withCustomTemplates())
            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .header("User-Agent", "MockClient/0.1 by Me");

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(200)
            .build();
}
