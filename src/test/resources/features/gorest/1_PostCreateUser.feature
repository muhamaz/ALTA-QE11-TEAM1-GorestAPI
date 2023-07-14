Feature: Create User

  Scenario: Create User with valid JSON
    Given POST Create user with valid JSON "CreateUser.json"
    When Send request POST Create user
    Then Status code should be 201 Created
    And Validate user feature with JSON Schema "CreateUserSchema.json"

  Scenario Outline: Create User with invalid JSON
    Given POST Create user with invalid JSON <jsonName>
    When Send request POST Create user
    Then Status code should be <statusCode> Unprocessable Entity
    And Response body should be display error mesage <errorMessage>
    And Validate user feature with JSON Schema <jsonSchName>
    Examples:
      | jsonName                     | statusCode | errorMessage                            | jsonSchName                  |
      | "CreateUserEmptyName.json"   | 422        | "can't be blank"                        | "CreateUserErrorSchema.json" |
      | "CreateUserEmptyGender.json" | 422        | "can't be blank, can be male of female" | "CreateUserErrorSchema.json" |
      | "CreateUserEmptyEmail.json"  | 422        | "can't be blank"                        | "CreateUserErrorSchema.json" |

  Scenario: Create User with empty JSON
    Given POST Create user with invalid JSON "CreateUserEmptyJSON.json"
    When Send request POST Create user
    Then Status code should be 422 Unprocessable Entity
    And Response body should be display error mesage "field can't be blank"

