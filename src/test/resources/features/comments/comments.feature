Feature: Validate /comments endpoint  (https://jsonplaceholder.typicode.com/comments)

  @comments
  Scenario: Validate that the endpoint /comments lists all resources correctly

    Given The endpoint "/comments" having method "GET" is called to lists all resources
    Then The response data is validated against standard response specification
    And The content of the response body is validated against datasource or source of truth

  @comments
  Scenario: Validate that the endpoint /comments/{commentId}  lists individual resource correctly

    Given The endpoint "/comments/{commentId}" having method "GET" and PathParam "commentId" is called to perform CRUD operations on a random resource index
    And The response data is validated against standard response specification
    And The content of the response body is validated against datasource values filtered by same random resource index

  @comments
  Scenario: Validate that the endpoint /comments creates  a new resources correctly

    Given The endpoint "/comments" having method "POST" is called to create new resources
    Then The response data is validated against standard response specification
    And The content of the response body is validated against value passed in API call as actual data is not persisted

  @comments
  Scenario: Validate that the endpoint /comments/{commentId}   updates an existing resources correctly

    Given The endpoint "/comments/{commentId}" having method "PUT" and PathParam "commentId" is called to perform CRUD operations on a random resource index
    Then The response data is validated against standard response specification
    And The content of the response body is validated against value passed in API call as actual data is not persisted

  @comments
  Scenario: Validate that the endpoint /comments/{commentId}  patches an existing resources correctly

    Given The endpoint "/comments/{commentId}" having method "PATCH" and PathParam "commentId" is called to perform CRUD operations on a random resource index
    Then The response data is validated against standard response specification
    And The content of the response body is validated against value passed in API call as actual data is not persisted

  @comments
  Scenario: Validate that the endpoint /comments/{commentId}  deletes an existing resources correctly

    Given The endpoint "/comments/{commentId}" having method "DELETE" and PathParam "commentId" is called to perform CRUD operations on a random resource index
    Then The response data is validated against standard response specification
    And The content of the response body for delete endpoints are validated as blank or empty

  @comments
  Scenario: Validate that the endpoint /comments?postId=1 with query parameter fetches the filtered resources correctly

    Given The endpoint "/comments" having method "GET" and QueryParam "postId" is called with a random resource index to fetch list of qualified resources
    Then The response data is validated against standard response specification
    And The list of qualified resources in response body is validated against list of qualified resources in datasource filtered by same random resource index


