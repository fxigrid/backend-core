Feature: Quick Sanity Check on all the endpoints with valid and invalid query parameters

  @sanity
  Scenario Outline: Validate that the endpoint /endpoint?queryParam=1... with query parameter fetches the filtered resources if any correctly

    Given The endpoint "<endpoint>" having method "<method>" is called with QueryParameters "<QueryParameterName1>" and "<QueryParameterValues1>" and "<QueryParameterName2>" and "<QueryParameterValues2>"
    Then The response data is validated against standard response specification
    And The content of the response body is validated against flag <isResponseBodyEmpty> set based on valid QueryParams passed

    Examples:
      | endpoint  | method | QueryParameterName1 | QueryParameterValues1 | QueryParameterName2 | QueryParameterValues2 | isResponseBodyEmpty |
      | /comments | GET    | id                  | 21                    | postId              | 5                     | false               |
      | /comments | GET    | id                  | 21555                 |                     |                       | true                |
      | /users    | GET    | username            | Bret                  | website             | hildegard.org         | false               |
      | /users    | GET    | username            | Bret                  | website             | google.com            | true                |
      | /posts    | GET    | userId              | 1                     | id                  | 3                     | false               |
      | /posts    | GET    | title               | New Title             | body                | New Body              | true                |