package com.jpmc.social.backendcore.connectors.utilities;

import com.jpmc.social.backendcore.restUtilities.RestMethod;
import com.jpmc.social.backendcore.restUtilities.RestServices;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RequestCreationHelper {

    @Autowired
    private TestDataRepository testDataRepository;
    @Autowired
    private TestDataGenerator testDataGenerator;
    @Autowired
    private RestServices restServices;

    /**
     * Configure Rest Assured' RequestSpecBuilder with pathParam and API body if any
     * @param endpointCalled : endpoint to be called
     * @param methodName     : method used to invoke endpoint
     * @param pathParam      : path parameters in endpoint
     */
    public void setRequestPathParams_WithRandomValues(String endpointCalled, String methodName, String pathParam) {

        // Configuring Random PathParams
        this.testDataRepository.setRandomIndex(this.testDataGenerator.getRandomIntegerLessThan10());
        Map<String, Integer> mapPathParam = new HashMap<>();
        mapPathParam.put(pathParam, this.testDataRepository.getRandomIndex());
        this.restServices.configurePathParams(mapPathParam);

        // Configure API Body for  PUT and PATCH calls
        if (RestMethod.getMethodName(methodName).equals(RestMethod.PUT)
                || RestMethod.getMethodName(methodName).equals(RestMethod.PATCH)) {
            if (endpointCalled.contains("comments")) {
                this.testDataRepository.setCommentVo(this.testDataGenerator.getCommentVo());
                this.testDataRepository.getCommentVo().setId(this.testDataRepository.getRandomIndex());
                this.restServices.configureAPIBody(this.testDataRepository.getCommentVo());
            } else if (endpointCalled.contains("posts")) {
                this.testDataRepository.setPostVo(this.testDataGenerator.getPostVO());
                this.testDataRepository.getPostVo().setId(this.testDataRepository.getRandomIndex());
                this.restServices.configureAPIBody(this.testDataRepository.getPostVo());
            } else if (endpointCalled.contains("users")) {
                this.testDataRepository.setUserVo(this.testDataGenerator.getUserVo());
                this.testDataRepository.getUserVo().setId(this.testDataRepository.getRandomIndex());
                this.restServices.configureAPIBody(this.testDataRepository.getUserVo());
            }
        }
    }

    /**
     * Configure Rest Assured' RequestSpecBuilder with API body
     * @param endpointCalled : endpoint to be called
     */
    public void setRequestBodyValues(String endpointCalled) {

        //Configure Request body
        if (endpointCalled.contains("comments")) {
            this.testDataRepository.setCommentVo(this.testDataGenerator.getCommentVo());
            this.restServices.configureAPIBody(this.testDataRepository.getCommentVo());
        } else if (endpointCalled.contains("posts")) {
            this.testDataRepository.setPostVo(this.testDataGenerator.getPostVO());
            this.restServices.configureAPIBody(this.testDataRepository.getPostVo());
        } else if (endpointCalled.contains("users")) {
            this.testDataRepository.setUserVo(this.testDataGenerator.getUserVo());
            this.restServices.configureAPIBody(this.testDataRepository.getUserVo());
        }
    }

    /**
     * Configure Rest Assured' RequestSpecBuilder with queryParam
     * @param queryParam : query parameters in endpoint
     */
    public void setRequestQueryParams_WithRandomValues(String queryParam) {

        // Creating  queryParam with Random values
        this.testDataRepository.setRandomIndex(this.testDataGenerator.getRandomIntegerLessThan10());
        Map<String, Integer> mapQueryParam = new HashMap<>();
        mapQueryParam.put(queryParam, this.testDataRepository.getRandomIndex());
        this.restServices.configureQueryParams(mapQueryParam);
    }

    /**
     * Configure Rest Assured' RequestSpecBuilder with queryParams
     * @param queryParameterName1 : query param 1 name
     * @param queryParameterValues1 : query param1 value
     * @param queryParameterName2   :query param2 name
     * @param queryParameterValues2 :query param2 value
     */
    public void setRequestQueryParams_WithPassedValues(String queryParameterName1, String queryParameterValues1, String queryParameterName2, String queryParameterValues2) {

        // Creating  queryParam with passed values
        Map<String, String> mapQueryParam = new HashMap<>();
        if (StringUtils.isNotEmpty(queryParameterName1)) {
            mapQueryParam.put(queryParameterName1, queryParameterValues1);
        }
        if (StringUtils.isNotEmpty(queryParameterName2)) {
            mapQueryParam.put(queryParameterName2, queryParameterValues2);
        }
        this.restServices.configureQueryParams(mapQueryParam);
    }

}
