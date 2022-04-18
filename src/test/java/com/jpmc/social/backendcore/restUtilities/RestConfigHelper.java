package com.jpmc.social.backendcore.restUtilities;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

@Configuration
public class RestConfigHelper {

    @Value("${base.uri}")
    private String baseUri;
    private RestMethod restMethod;
    private String endPoint;

    public RestMethod getRestMethod() {
        return restMethod;
    }

    public void setRestMethod(RestMethod restMethod) {
        this.restMethod = restMethod;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getBaseUri() {
        return baseUri;
    }

    @Bean
    public RequestSpecBuilder getRequestSpecBuilder() {
        return new RequestSpecBuilder();
    }

    @Bean
    public RequestSpecification getRequestSpecification() {
        return RestAssured.given().contentType(ContentType.JSON).and();
    }

    @Bean
    public ResponseSpecification getResponseSpecification() {
        return RestAssured.expect().contentType(ContentType.JSON)
                .statusCode(anyOf(is(200), is(201)))
                .time(Matchers.lessThan(5000L));
    }

    @Bean
    public Faker getFaker(){
        return new Faker();
    }

}
