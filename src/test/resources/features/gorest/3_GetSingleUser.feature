Feature: Get Single User

  Scenario: Get Single user with valid parameter id user
    Given GET Single user with valid parameter id 3615562
    When Send request GET Single user
    Then Status code should be 200 OK
    And Response body id should be 3615562
    And Validate user feature with JSON Schema "SingleUserSchema.json"

  Scenario: Get Single user with unregistered parameter id user
    Given GET Single user with unregistered parameter id 1
    When Send request GET Single user
    Then Status code should be 404 Not Found
    And Response body should be display error message "Resource not found"
    And Validate user feature with JSON Schema "SingleUserErrorSchema.json"

  Scenario: Get Single user with invalid parameter id user
    Given GET Single user with invalid parameter id "%$#"
    When Send request GET Single user
    Then Status code should be 404 Not Found