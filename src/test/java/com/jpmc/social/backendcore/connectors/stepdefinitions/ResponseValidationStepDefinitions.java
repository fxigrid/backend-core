package com.jpmc.social.backendcore.connectors.stepdefinitions;

import com.jpmc.social.backendcore.connectors.dao.DBAccessService;
import com.jpmc.social.backendcore.connectors.utilities.ResponseValidationHelper;
import com.jpmc.social.backendcore.connectors.utilities.TestDataRepository;
import com.jpmc.social.backendcore.restUtilities.RestServices;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ResponseValidationStepDefinitions {

    @Autowired
    private RestServices restServices;
    @Autowired
    private TestDataRepository testDataRepository;
    @Autowired
    private ResponseValidationHelper responseValidationHelper;
    @Autowired
    @Qualifier("jsonLayerService")
    private DBAccessService dbAccessService;

    @And("The content of the response body is validated against datasource or source of truth")
    public void theContentOfTheResponseBodyIsValidatedAgainstDatasourceOrSourceOfTruth() {
        // Retrieve response from TestDataRepository and Compare with Source of Truth ==> DB
        this.responseValidationHelper.validate_APIResponseDataValues_MatchesWith_DBDataValues();
    }

    @And("The content of the response body is validated against datasource values filtered by same random resource index")
    public void theContentOfTheResponseBodyIsValidatedAgainstFilteredDatasourceOrSourceOfTruth() {
        // Retrieve response from TestDataRepository and Compare with Source of Truth ==> DB Filtered
        this.responseValidationHelper.validate_APIResponseDataValues_MatchesWith_DBValues_FilteredByRandomIndex();
    }

    @And("The content of the response body is validated against value passed in API call as actual data is not persisted")
    public void theContentOfTheResponseBodyIsValidatedAgainstNewlyPostedValue() {
        // Retrieve response from TestDataRepository and Compare with Source of Truth ==> Request Call Body
        this.responseValidationHelper.validate_APIResponseDataValues_MatchesWith_APIRequestDataValues();
    }

    @And("The list of qualified resources in response body is validated against list of qualified resources in datasource filtered by same random resource index")
    public void theContentOfTheResponseBodyIsValidatedAgainstFilteredValue() {
        // Retrieve response from TestDataRepository and Compare with Source of Truth ==> DB Filtered
        this.responseValidationHelper.validate_ListOfQualifiedResources_In_API_Matches_DB_FilteredBySame_RandomIndex();
    }

    @And("The content of the response body for delete endpoints are validated as blank or empty")
    public void theContentOfTheResponseBodyIsValidatedAgainstDeletedValue() {
        // Retrieve response from TestDataRepository and Validate Delete have blank responses
        boolean isDeleted = this.testDataRepository.getResponse().getBody().asString().equalsIgnoreCase("{}");
        Assert.assertTrue("Assertion Failed : Values Not Deleted", isDeleted);
    }

    @And("The response data is validated against standard response specification")
    public void theResponseDataIsValidatedAgainstStandardResponseSpecification() {
        // Retrieve response from TestDataRepository and Validate contentType =ContentType.JSON,StatusCode = 200 or 201
        this.restServices.responseSpecificationValidation(this.testDataRepository.getResponse());
    }

    @And("The content of the response body is validated against flag {booleanValue} set based on valid QueryParams passed")
    public void theContentOfTheResponseBodyIsValidatedAgainstFlagSetBasedOnValidQueryParamsPassed(Boolean isResponseBodyEmpty) {
        // Retrieve response from TestDataRepository and the response are empty for invalid query params
        this.responseValidationHelper.validate_responseData_list_matches_flag_passed(isResponseBodyEmpty);
    }
}
