Feature: Validate /posts Endpoint  (https://jsonplaceholder.typicode.com/posts)

  @posts
  Scenario: Validate that the endpoint /posts lists all resources correctly

    Given The endpoint "/posts" having method "GET" is called to lists all resources
    Then The response data is validated against standard response specification
    And The content of the response body is validated against datasource or source of truth

  @posts
  Scenario: Validate that the endpoint /posts/{postId}  lists individual resources correctly

    Given The endpoint "/posts/{postId}" having method "GET" and PathParam "postId" is called to perform CRUD operations on a random resource index
    And The response data is validated against standard response specification
    And The content of the response body is validated against datasource values filtered by same random resource index

  @posts
  Scenario: Validate the endpoint /posts creates  a new resources correctly

    Given The endpoint "/posts" having method "POST" is called to create new resources
    Then The response data is validated against standard response specification
    And The content of the response body is validated against value passed in API call as actual data is not persisted

  @posts
  Scenario: Validate the endpoint /posts/{postId}  a updates an existing resources correctly

    Given The endpoint "/posts/{postId}" having method "PUT" and PathParam "postId" is called to perform CRUD operations on a random resource index
    Then The response data is validated against standard response specification
    And The content of the response body is validated against value passed in API call as actual data is not persisted

  @posts
  Scenario: Validate the endpoint /posts/{postId}  patches an existing resources correctly

    Given The endpoint "/posts/{postId}" having method "PATCH" and PathParam "postId" is called to perform CRUD operations on a random resource index
    Then The response data is validated against standard response specification
    And The content of the response body is validated against value passed in API call as actual data is not persisted

  @posts
  Scenario: Validate the endpoint /posts/{postId}  deletes an existing resources correctly

    Given The endpoint "/posts/{postId}" having method "DELETE" and PathParam "postId" is called to perform CRUD operations on a random resource index
    Then The response data is validated against standard response specification
    And The content of the response body for delete endpoints are validated as blank or empty

  @posts
  Scenario: Validate the endpoint /posts/?userId=  with query parameter fetches the filtered resources correctly

    Given The endpoint "/posts" having method "GET" and QueryParam "userId" is called with a random resource index to fetch list of qualified resources
    Then The response data is validated against standard response specification
    And The list of qualified resources in response body is validated against list of qualified resources in datasource filtered by same random resource index