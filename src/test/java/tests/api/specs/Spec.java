package tests.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Spec {
    public static RequestSpecification request = with()
            .log().all()
            //.baseUri("https://oauth.reddit.com/api")
            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .header("User-Agent", "MockClient/0.1 by Me");

    public static ResponseSpecification response = new ResponseSpecBuilder()
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .build();
}
