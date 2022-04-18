## Rest API Test Automation Project
This project executes automation test for the

#### Service :  https://jsonplaceholder.typicode.com/ having endpoints:
    
    *posts:         https://jsonplaceholder.typicode.com/posts 
    *comments:      https://jsonplaceholder.typicode.com/comments
    *users:         https://jsonplaceholder.typicode.com/users

## Tech Stack
* Java 11
* JUnit 5.x (Jupiter)
* Cucumber 7.x
* Spring Boot 2.6.6
* Rest Assured 4.5.1

### Run all the cases in CMD

         mvn clean verify 

### Run the specific tags/functionality available in feature file in CMD

        mvn clean verify -Dcucumber.filter.tags="@users or @posts or @comments or @sanity" 
        mvn clean verify -Dcucumber.filter.tags="@users"
        mvn clean verify -Dcucumber.filter.tags="@posts"
        mvn clean verify -Dcucumber.filter.tags="@comments"
        mvn clean verify -Dcucumber.filter.tags="@sanity"

### Test Reports are available at:

         /target/Reports/cucumber-html-reports/***