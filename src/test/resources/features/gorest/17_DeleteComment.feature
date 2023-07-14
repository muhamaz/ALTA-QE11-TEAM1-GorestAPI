Feature: Delete Comment

  Scenario: Delete comment with valid id comment
    Given DELETE comment with valid id 45466
    When Send request DELETE comment
    Then Status code should be 204 No Content

  Scenario: Delete comment with invalid id comment
    Given DELETE comment with invalid id 45399
    When Send request DELETE comment
    Then Status code should be 404 Not Found
    And Response body should be display error message "Resource not found"
    And Validate comment feature with JSON Schema "DeleteErrorSchema.json"