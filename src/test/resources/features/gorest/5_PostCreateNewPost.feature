Feature: Create New Post

  Scenario: Create new post with valid parameter user id and valid JSON
    Given POST Create new post with valid parameter id 3615562 and JSON "CreateNewPost.json"
    When Send request POST Create new post
    Then Status code should be 201 Created
    And Response body user id was 3615562 and title was "testing api" and body was "this is how to create a post"
    And Validate post feature with JSON Schema "CreatePostSchema.json"

  Scenario Outline: Create new post with valid parameter user id and invalid JSON body
    Given POST Create new post with valid parameter id <id> and JSON <jsonName>
    When Send request POST Create new post
    Then Status code should be <statusCode> Unprocessable Entity
    And Response body should be display err message <errorMessage>
    And Validate post feature with JSON Schema <jsonSchName>
    Examples:
      | id      | jsonName                    | statusCode | errorMessage     | jsonSchName                  |
      | 3615562 | "CreatePostEmptyTitle.json" | 422        | "can't be blank" | "CreatePostErrorSchema.json" |
      | 3615562 | "CreatePostEmptyBody.json"  | 422        | "can't be blank" | "CreatePostErrorSchema.json" |

  @Post @Negative @Bug
  Scenario: Create new post with valid parameter user id and blank JSON body
    Given POST Create new post with valid parameter id 3615562 and JSON "CreateBlank.json"
    When Send request POST Create new post
    Then Status code should be 422 Unprocessable Entity
    And Response body should be display err message "all field can't be blank"

  @Post @Negative @Bug
  Scenario: Create new post with another field hobby
    Given POST Create new post with valid parameter id 3615562 and JSON "CreatePostAnother.json"
    When Send request POST Create new post
    Then Status code should be 404 Not Found