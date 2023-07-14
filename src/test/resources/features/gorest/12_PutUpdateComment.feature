Feature: Put Update Comment

@Comments @Positive
  Scenario: Update comment with valid parameter id comment and valid JSON
    Given PUT Update comment with id 45404 and JSON "UpdateComment.json"
    When Send request PUT Update comment
    Then Status code should be 200 OK
    And Validate comment feature with JSON Schema "UpdateCommentSchema.json"

@Comments @Negative
  Scenario: Update comment with invalid parameter id comment and valid JSON
    Given PUT Update comment with id 1 and JSON "UpdateComment.json"
    When Send request PUT Update comment
    Then Status code should be 404 Not Found
    And Response body should be display error message "Resource not found"
    And Validate comment feature with JSON Schema "InvIDUpdateCommentSchema.json"

@Comments @Negative
  Scenario Outline: Update comment with valid parameter id comment and invalid JSON
    Given PUT Update comment with id <id> and JSON <jsonName>
    When Send request PUT Update comment
    Then Status code should be <statusCode> Unprocessable Entity
    And Response body should be display error <errorMsg>
    And Validate comment feature with JSON Schema <jsonSchName>
    Examples:
      | id    | jsonName                | statusCode | errorMsg                     | jsonSchName              |
      | 45404 | "UpdateEmptyName.json"  | 422        | "can't be blank"             | "UpdateErrorSchema.json" |
      | 45404 | "UpdateEmptyEmail.json" | 422        | "can't be blank, is invalid" | "UpdateErrorSchema.json" |
      | 45404 | "UpdateEmptyBody.json"  | 422        | "can't be blank"             | "UpdateErrorSchema.json" |

@Comments @Negative @Bug
  Scenario: Update comment with valid parameter id comment and empty JSON
    Given PUT Update comment with id 45404 and JSON "UpdateEmptyJSON.json"
    When Send request PUT Update comment
    Then Status code should be 422 Unprocessable Entity
    And Response body should be display error "field can't be blank"