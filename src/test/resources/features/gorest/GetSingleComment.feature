Feature: Get Single Comment

  Scenario: Get Single Comment with valid parameter id comment
    Given GET Single comment with parameter id 45404
    When Send GET Single comment
    Then Status code should be 200 OK
    And Response body id should be 45404
    And Validate with JSON Schema "SingleCommentSchema.json"


  Scenario: Get Single Comment with invalid parameter id comment
    Given GET Single comment with parameter id 1
    When Send GET Single comment
    Then Status code should be 404 Not Found
    And Response body should be display error message "Resource not found"
    And Validate with JSON Schema "SingleCommentErrorSchema.json"