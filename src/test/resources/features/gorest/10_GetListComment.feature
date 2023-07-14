Feature: Get List Comments

@Comments @Positive
  Scenario: Get list comment with valid path
    Given GET list comment with valid path "comments"
    When Send request GET list comment
    Then Status code should be 200 OK
    And Validate comment feature with JSON Schema "ListCommentSchema.json"

@Comments @negative
  Scenario: Get list comment with invalid path
    Given GET list comment with invalid path "xyz"
    When Send request GET list comment
    Then Status code should be 404 Not Found