Feature: Get Single Comment

@Comments @Positive
  Scenario: Get Single Comment with valid parameter id comment
    Given GET Single comment with parameter id 45404
    When Send request GET Single comment
    Then Status code should be 200 OK
    And Response body id should be 45404
    And Validate comment feature with JSON Schema "SingleCommentSchema.json"

@Comments @Negative
  Scenario: Get Single Comment with invalid parameter id comment
    Given GET Single comment with parameter id 1
    When Send request GET Single comment
    Then Status code should be 404 Not Found
    And Response body should be display error message "Resource not found"
    And Validate comment feature with JSON Schema "SingleCommentErrorSchema.json"