package com.jpmc.social.backendcore.connectors.stepdefinitions;

import com.jpmc.social.backendcore.connectors.utilities.RequestCreationHelper;
import com.jpmc.social.backendcore.connectors.utilities.TestDataGenerator;
import com.jpmc.social.backendcore.connectors.utilities.TestDataRepository;
import com.jpmc.social.backendcore.restUtilities.RestMethod;
import com.jpmc.social.backendcore.restUtilities.RestServices;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class RequestCreationsStepDefinitions {

    @Autowired
    private RestServices restServices;
    @Autowired
    private TestDataRepository testDataRepository;
    @Autowired
    private TestDataGenerator testDataGenerator;
    @Autowired
    private RequestCreationHelper requestCreationHelper;

    @Given("The endpoint {string} having method {string} is called to lists all resources")
    public void theEndpointHavingMethodIsCalledToListsAllResources(String endpointCalled, String methodName) {
        // Configure API, Trigger Call and Store Response to TestDataRepository for validations
        this.restServices.configureRestService(RestMethod.getMethodName(methodName), endpointCalled);
        this.testDataRepository.setResponse(this.restServices.executeConfiguredAPI());
    }

    @Given("The endpoint {string} having method {string} and PathParam {string} is called to perform CRUD operations on a random resource index")
    public void theEndpointHavingMethodAndPathParamIsCalledToListsAllResources(String endpointCalled, String methodName, String pathParam) {
        // Configure API, Trigger Call and Store Response to TestDataRepository for validations
        this.restServices.configureRestService(RestMethod.getMethodName(methodName), endpointCalled);
        this.requestCreationHelper.setRequestPathParams_WithRandomValues(endpointCalled, methodName, pathParam);
        this.testDataRepository.setResponse(this.restServices.executeConfiguredAPI());
    }

    @Given("The endpoint {string} having method {string} is called to create new resources")
    public void theEndpointHavingMethodIsCalledToCreateNewResources(String endpointCalled, String methodName) {
        // Configure API, Trigger Call and Store Response to TestDataRepository for validations
        this.restServices.configureRestService(RestMethod.getMethodName(methodName), endpointCalled);
        this.requestCreationHelper.setRequestBodyValues(endpointCalled);
        this.testDataRepository.setResponse(this.restServices.executeConfiguredAPI());
    }

    @Given("The endpoint {string} having method {string} and QueryParam {string} is called with a random resource index to fetch list of qualified resources")
    public void theEndpointHavingMethodAndQueryParamIsCalledToGetOrUpdateResources(String endpointCalled, String methodName, String queryParam) {
        // Configure API, Trigger Call and Store Response to TestDataRepository for validations
        this.restServices.configureRestService(RestMethod.getMethodName(methodName), endpointCalled);
        this.requestCreationHelper.setRequestQueryParams_WithRandomValues(queryParam);
        this.testDataRepository.setResponse(this.restServices.executeConfiguredAPI());
    }

    @Given("The endpoint {string} having method {string} is called with QueryParameters {string} and {string} and {string} and {string}")
    public void theEndpointHavingMethodIsCalledWithQueryParametersAndAndAnd(String endpointCalled, String methodName, String QueryParameterName1, String QueryParameterValues1, String QueryParameterName2, String QueryParameterValues2) {
        // Configure API, Trigger Call and Store Response to TestDataRepository for validations
        this.restServices.configureRestService(RestMethod.getMethodName(methodName), endpointCalled);
        this.requestCreationHelper.setRequestQueryParams_WithPassedValues(QueryParameterName1, QueryParameterValues1, QueryParameterName2, QueryParameterValues2);
        this.testDataRepository.setResponse(this.restServices.executeConfiguredAPI());
    }
}
