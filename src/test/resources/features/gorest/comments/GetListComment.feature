Feature: Get List Comments

  Scenario: Get list comment with valid path
    Given GET list comment with valid path "comments"
    When Send GET list comment
    Then Status code should be 200 OK
    And Validate with JSON Schema "ListCommentSchema.json"


  Scenario: Get list comment with invalid path
    Given GET list comment with invalid path "xyz"
    When Send GET list comment
    Then Status code should be 404 Not Found