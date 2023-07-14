Feature: Get list posts

  Scenario: Get list post with valid path
    Given GET list post with valid path "posts"
    When Send request GET list post
    Then Status code should be 200 OK
    And Validate post feature with JSON Schema "ListPostSchema.json"

  Scenario: Get list post with invalid path
    Given GET list post with valid path "lol"
    When Send request GET list post
    Then Status code should be 404 Not Found
