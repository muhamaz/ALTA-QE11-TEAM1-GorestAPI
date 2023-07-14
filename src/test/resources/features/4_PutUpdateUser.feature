Feature: Update User

  Scenario: Put update user with valid JSON and valid parameter id user
    Given Given PUT Update user with JSON "UpdateUser.json" and parameter id 3615562
    When Send request PUT Update user
    Then Status code should be 200 OK
    And Response body id should be id 3615562
    And Validate user feature with JSON Schema "UpdateUserSchema.json"

  Scenario: Put update user with valid JSON and invalid parameter id user
    Given Given PUT Update user with JSON "UpdateUser.json" and parameter id 1
    When Send request PUT Update user
    Then Status code should be 404 Not Found
    And Response body should be display eror mesage "Resource not found"
    And Validate user feature with JSON Schema "UpdateUserErrorSchema.json"

  Scenario Outline: Put update user with invalid JSON and valid parameter id user
    Given Given PUT Update user with JSON <jsonName> and parameter id <id>
    When Send request PUT Update user
    Then Status code should be <statusCode> Unprocessable Entity
    And Response body should be display error mesage <errorMessage>
    And Validate user feature with JSON Schema <jsonSchName>
    Examples:
      | jsonName                     | id      | statusCode | errorMessage                            | jsonSchName                     |
      | "UpdateUserEmptyName.json"   | 3615562 | 422        | "can't be blank"                        | "UpUserInvalidErrorSchema.json" |
      | "UpdateUserEmptyGender.json" | 3615562 | 422        | "can't be blank, can be male of female" | "UpUserInvalidErrorSchema.json" |
      | "UpdateUserEmptyStatus.json" | 3615562 | 422        | "can't be blank"                        | "UpUserInvalidErrorSchema.json" |
      | "UpdateUserEmptyEmail.json"  | 3615562 | 422        | "can't be blank"                        | "UpUserInvalidErrorSchema.json" |

  Scenario: Put update user with empty JSON and valid parameter id user
    Given Given PUT Update user with JSON "UpdateEmptyJSON.json" and parameter id 3615562
    When Send request PUT Update user
    Then Status code should be 422 Unprocessable Entity
    And Response body should be display error mesage "field can't be blank"
