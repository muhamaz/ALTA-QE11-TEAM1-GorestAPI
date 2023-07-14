Feature: Get Single Post

  Scenario: Get Single post with valid post id
    Given GET Single post with valid post id 3615562
    When Send request GET Single post
    Then Status code should be 200 OK
    And Validate post feature with JSON Schema "SinglePostSchema.json"

@Post @Negative @Bug
  Scenario: Get Single post with invalid id user
    Given GET Single post with invalid post id "#%@"
    When Send request GET Single post
    Then Status code should be 404 Not Found
