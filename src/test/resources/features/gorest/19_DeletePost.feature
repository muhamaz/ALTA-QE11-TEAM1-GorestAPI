Feature: Delete post

  Scenario: Delete post with valid parameter id
    Given DELETE post with valid id 51341
    When Send request DELETE post
    Then Status code should be 204 No Content

  Scenario: Delete post with invalid id comment
    Given DELETE post with invalid id 9999999
    When Send request DELETE post
    Then Status code should be 404 Not Found
    And Response body should be display err msg "Resource not found"
    And Validate post feature with JSON Schema "DeletePostSchema.json"