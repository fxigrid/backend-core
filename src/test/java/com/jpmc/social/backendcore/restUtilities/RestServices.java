package com.jpmc.social.backendcore.restUtilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class RestServices {

    @Autowired
    public RestConfigHelper restConfigHelper;
    @Autowired
    private RequestSpecBuilder requestSpecBuilder;
    @Autowired
    private RequestSpecification requestSpecification;
    @Autowired
    private ResponseSpecification responseSpecification;


    /**
     * Configure Custom RestService with restMethod and endPoint for Subsequent usage
     * @param restMethod : method used to invoke endpoint
     * @param endPoint  : endpoint to be called
     */
    public void configureRestService(RestMethod restMethod, String endPoint) {
        restConfigHelper.setRestMethod(restMethod);
        restConfigHelper.setEndPoint(endPoint);
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecification = RestAssured.given().contentType(ContentType.JSON).and();
    }

    /**
     * Configure Rest Assured' RequestSpecBuilder with queryParam
     * @param queryPath : path parameters to be configured in  endpoint
     */
    public void configureQueryParams(Map<String, ?> queryPath) {
        requestSpecBuilder.addQueryParams(queryPath);
    }

    /**
     * Configure Rest Assured' RequestSpecBuilder with pathParams
     * @param pathParams : path parameters to be configured in  endpoint
     */
    public void configurePathParams(Map<String, ?>  pathParams) {
        requestSpecBuilder.addPathParams(pathParams);
    }

    /**
     * Configure Rest Assured' RequestSpecBuilder with body to be passed
     * @param object : body object as map or json object or pojo
     */
    public void configureAPIBody(Object object) {
        requestSpecBuilder.setBody(object);
    }

    /**
     * Configure Rest Assured' RequestSpecBuilder with pathParams and body
     * @param pathParams : path parameters to be configured in  endpoint
     */
    public void configureAPIWithPathParamsAndBody(Map<String, String> pathParams, Object body) {
        requestSpecBuilder.setBody(body);
        requestSpecBuilder.addPathParams(pathParams);
    }


    /**
     * Execute the configured Rest Assured' RequestSpecification with corresponding method
     */
    public ResponseOptions<Response> executeConfiguredAPI() {
        String currentEndPoint = restConfigHelper.getEndPoint();
        RestMethod currentMethod = restConfigHelper.getRestMethod();
        requestSpecification.spec(requestSpecBuilder.build()).baseUri(restConfigHelper.getBaseUri());

        if (currentMethod.equals(RestMethod.POST)) {
            return requestSpecification.post(currentEndPoint);
        } else if (currentMethod.equals(RestMethod.DELETE)) {
            return requestSpecification.delete(currentEndPoint);
        } else if (currentMethod.equals(RestMethod.GET)) {
            return requestSpecification.get(currentEndPoint);
        } else if (currentMethod.equals(RestMethod.PATCH)) {
            return requestSpecification.patch(currentEndPoint);
        } else if (currentMethod.equals(RestMethod.PUT)) {
            return requestSpecification.put(currentEndPoint);
        } else {
            return null;
        }
    }

    /**
     *  Validate response against standard response specification
     */
    public void responseSpecificationValidation(ResponseOptions<Response> response) {
        // Validate Response against Standard  Specification like :ContentType.JSON  and  StatusCode= 200/201 and Execution time <5000ms
        response.andReturn().then().spec(this.responseSpecification);

    }


}
