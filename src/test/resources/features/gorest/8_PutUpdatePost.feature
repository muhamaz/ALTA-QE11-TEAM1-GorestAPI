Feature: Update Post


  Scenario: Update post with valid parameter id and valid JSON
    Given PUT Update post with id 51114 and JSON "UpdatePost.json"
    When Send request PUT Update post
    Then Status code should be 200 OK
    And Validate post feature with JSON Schema "UpdatePostSchema.json"

  Scenario: Update post with invalid parameter id and valid JSON
    Given PUT Update post with id 563456 and JSON "UpdatePost.json"
    When Send request PUT Update post
    Then Status code should be 404 Not Found
    And Response body should be display err msg "Resource not found"
    And Validate post feature with JSON Schema "UpdatePostInvalidSchema.json"

@Post @Negative @Bug
  Scenario: Update posts with unexpected body JSON
    Given PUT Update post with id 51114 and JSON "UpdateUnexpected.json"
    When Send request PUT Update post
    Then Status code should be 400 Bad Request

  Scenario Outline: Update post with valid parameter id and invalid JSON
    Given PUT Update post with id <id> and JSON <jsonName>
    When Send request PUT Update post
    Then Status code should be <statusCode> Unprocessable Entity
    And Response body should be display eror msg <errorMessage>
    And Validate post feature with JSON Schema <jsonSchName>
    Examples:
      | id    | jsonName                    | statusCode | errorMessage     | jsonSchName                  |
      | 51114 | "UpdateEmptyTitlePost.json" | 422        | "can't be blank" | "UpdatePostErrorSchema.json" |
      | 51114 | "UpdateEmptyBodyPost.json"  | 422        | "can't be blank" | "UpdatePostErrorSchema.json" |

  @Post @Negative @Bug
  Scenario: Update post with valid parameter id and blank JSON body
    Given PUT Update post with id 51114 and JSON "UpdatePostBlank.json"
    When Send request PUT Update post
    Then Status code should be 422 Unprocessable Entity
    And Response body should be display eror msg "all field can't be blank"
