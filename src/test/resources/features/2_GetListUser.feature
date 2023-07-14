Feature: Get List User

  @Comments @Positive
  Scenario: Get list user with valid path
    Given GET list user with valid path "users"
    When Send request GET list user
    Then Status code should be 200 OK
    And Validate user feature with JSON Schema "ListUserSchema.json"

  @Comments @negative
  Scenario: Get list user with invalid path
    Given GET list user with invalid path "xyz"
    When Send request GET list user
    Then Status code should be 404 Not Found