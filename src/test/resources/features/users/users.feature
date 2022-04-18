Feature: Validate /users Endpoint  (https://jsonplaceholder.typicode.com/users)

  @users
  Scenario: Validate the endpoint /users lists all resources correctly

    Given The endpoint "/users" having method "GET" is called to lists all resources
    Then The response data is validated against standard response specification
    And The content of the response body is validated against datasource or source of truth

  @users
  Scenario: Validate the endpoint /users/{userId}  lists individual resources correctly

    Given The endpoint "/users/{userId}" having method "GET" and PathParam "userId" is called to perform CRUD operations on a random resource index
    And The response data is validated against standard response specification
    And The content of the response body is validated against datasource values filtered by same random resource index

  @users
  Scenario: Validate the endpoint /users creates  a new resources correctly

    Given The endpoint "/users" having method "POST" is called to create new resources
    Then The response data is validated against standard response specification
    And The content of the response body is validated against value passed in API call as actual data is not persisted

  @users
  Scenario: Validate the endpoint /users/{userId}  updates an existing resources correctly

    Given The endpoint "/users/{userId}" having method "PUT" and PathParam "userId" is called to perform CRUD operations on a random resource index
    Then The response data is validated against standard response specification
    And The content of the response body is validated against value passed in API call as actual data is not persisted

  @users
  Scenario: Validate the endpoint /users/{userId} patches an existing resources correctly

    Given The endpoint "/users/{userId}" having method "PATCH" and PathParam "userId" is called to perform CRUD operations on a random resource index
    Then The response data is validated against standard response specification
    And The content of the response body is validated against value passed in API call as actual data is not persisted

  @users
  Scenario: Validate the endpoint /users/{userId}   deletes an existing resources correctly

    Given The endpoint "/users/{userId}" having method "DELETE" and PathParam "userId" is called to perform CRUD operations on a random resource index
    Then The response data is validated against standard response specification
    And The content of the response body for delete endpoints are validated as blank or empty

  @users
  Scenario: Validate the endpoint /users?id=  with query parameter fetches the filtered resources correctly

    Given The endpoint "/users" having method "GET" and QueryParam "id" is called with a random resource index to fetch list of qualified resources
    Then The response data is validated against standard response specification
    And The list of qualified resources in response body is validated against list of qualified resources in datasource filtered by same random resource index
