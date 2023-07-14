Feature: Post Create New Comment

@Comments @Positive
  Scenario: Create new comment with valid post id and valid JSON
    Given POST Create new comment with post id 51114 and JSON "CreateComment.JSON"
    When Send request POST Create new comment
    Then Status code should be 201 Created
    And Response body id was 51114 and name was "Ratu Elizabeth" and email "elizabeth@test.com" and body "this is how we can create a comment"
    And Validate comment feature with JSON Schema "CreateCommentSchema.json"

@Comments @negative
  Scenario: Create new comment with invalid post id and valid JSON
    Given POST Create new comment with post id 1 and JSON "CreateComment.JSON"
    When Send request POST Create new comment
    Then Status code should be 422 Unprocessable Entity
    And Response body should be display error "must exist"
    And Validate comment feature with JSON Schema "InvIDCreateCommentSchema.json"

@Comments @Negative
  Scenario Outline: Create new comment with valid post id and invalid JSON
    Given POST Create new comment with post id <id> and JSON <jsonName>
    When Send request POST Create new comment
    Then Status code should be <statusCode> Unprocessable Entity
    And Response body should be display error <errorMsg>
    And Validate comment feature with JSON Schema <jsonSchName>
    Examples:
      | id    | jsonName                | statusCode | errorMsg                     | jsonSchName                     |
      | 51114 | "CreateEmptyName.json"  | 422        | "can't be blank"             | "CreateCommentErrorSchema.json" |
      | 51114 | "CreateEmptyEmail.json" | 422        | "can't be blank, is invalid" | "CreateCommentErrorSchema.json" |
      | 51114 | "CreateEmptyBody.json"  | 422        | "can't be blank"             | "CreateCommentErrorSchema.json" |

@Comments @Negative @Bug
  Scenario: Create new comment with valid post id and empty JSON
    Given POST Create new comment with post id 51114 and JSON "CreateEmptyJSON.json"
    When Send request POST Create new comment
    Then Status code should be 422 Unprocessable Entity
    And Response body should be display error "field can't be blank"
