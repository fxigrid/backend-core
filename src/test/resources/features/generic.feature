# This is a generic feature file  to run all the endpoints in one go for similar set of scenarios
# The tags for it at feature file level has been commented as we are running test at individual endpoint levels
@generic
Feature: Validate all the endpoint in scenario outlines  (https://jsonplaceholder.typicode.com/endpoint)


  Scenario Outline: Validate the endpoint "/endpoint"   lists all resources correctly

    Given The endpoint "<endpoint>" having method "<method>" is called to lists all resources
    Then The response data is validated against standard response specification
    And The content of the response body is validated against datasource or source of truth

    Examples:
      | endpoint  | method |
      | /users    | GET    |
      | /comments | GET    |
      | /posts    | GET    |

  Scenario Outline: Validate the endpoint "/endpoint/{pathParam}"  lists individual resources correctly

    Given The endpoint "<endpoint>" having method "<method>" and PathParam "<pathParamName>" is called to perform CRUD operations on a random resource index
    And The response data is validated against standard response specification
    And The content of the response body is validated against datasource values filtered by same random resource index

    Examples:
      | endpoint              | method | pathParamName |
      | /users/{userId}       | GET    | userId        |
      | /comments/{commentId} | GET    | commentId     |
      | /posts/{postId}       | GET    | postId        |

  Scenario Outline: Validate the endpoint "/endpoint" creates  a new resources correctly

    Given The endpoint "<endpoint>" having method "<method>" is called to create new resources
    Then The response data is validated against standard response specification
    And The content of the response body is validated against value passed in API call as actual data is not persisted

    Examples:
      | endpoint  | method |
      | /users    | POST   |
      | /comments | POST   |
      | /posts    | POST   |

  Scenario Outline: Validate the endpoint "/endpoint/{pathParam}"  updates an existing resources correctly

    Given The endpoint "<endpoint>" having method "<method>" and PathParam "<pathParamName>" is called to perform CRUD operations on a random resource index
    Then The response data is validated against standard response specification
    And The content of the response body is validated against value passed in API call as actual data is not persisted

    Examples:
      | endpoint              | method | pathParamName |
      | /users/{userId}       | PUT    | userId        |
      | /comments/{commentId} | PUT    | commentId     |
      | /posts/{postId}       | PUT    | postId        |

  Scenario Outline: Validate the endpoint "/endpoint/{pathParam}" patches an existing resources correctly

    Given The endpoint "<endpoint>" having method "<method>" and PathParam "<pathParamName>" is called to perform CRUD operations on a random resource index
    Then The response data is validated against standard response specification
    And The content of the response body is validated against value passed in API call as actual data is not persisted

    Examples:
      | endpoint              | method | pathParamName |
      | /users/{userId}       | PATCH    | userId        |
      | /comments/{commentId} | PATCH    | commentId     |
      | /posts/{postId}       | PATCH    | postId        |

  Scenario Outline: Validate the endpoint "/endpoint/{pathParam}"   deletes an existing resources correctly

    Given The endpoint "<endpoint>" having method "<method>" and PathParam "<pathParamName>" is called to perform CRUD operations on a random resource index
    Then The response data is validated against standard response specification
    And The content of the response body for delete endpoints are validated as blank or empty

    Examples:
      | endpoint              | method | pathParamName |
      | /users/{userId}       | DELETE | userId        |
      | /comments/{commentId} | DELETE | commentId     |
      | /posts/{postId}       | DELETE | postId        |

  Scenario Outline: Validate the endpoint "/endpoint?queryParam="  with query parameter fetches the filtered resources correctly

    Given The endpoint "<endpoint>" having method "<method>" and QueryParam "<queryParamName>" is called with a random resource index to fetch list of qualified resources
    Then The response data is validated against standard response specification
    And The list of qualified resources in response body is validated against list of qualified resources in datasource filtered by same random resource index

    Examples:
      | endpoint  | method | queryParamName |
      | /users    | GET    | id             |
      | /comments | GET    | postId         |
      | /posts    | GET    | userId         |
