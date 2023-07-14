Feature: Post Create New Todos


  Scenario: Create new todos with valid path and JSON
    Given POST Create new todos with id 3615562 and JSON "CreateTodos.json"
    When Send request POST Create new todos
    Then Status code should be 201 Created
    And Validate todos feature with JSON Schema "CreateTodosSchema.json"


  Scenario: Create new todos with invalid user id and invalid JSON
    Given POST Create new todos with id 32678 and JSON "CreateTodosInvalid.json"
    When Send request POST Create new todos
    Then Status code should be 422 Unprocessable Entity
    And Response body should be show error message "must exist"
    And Validate todos feature with JSON Schema "CreateTodosInvalidSchema.json"

  Scenario: Create todos without due on in body request
    Given POST Create new todos with id 3615562 and JSON "CreateTodosDoOn.json"
    When Send request POST Create new todos
    Then Status code should be 201 Created
    And Validate todos feature with JSON Schema "CreateTodosDoOnShcema.json"

  Scenario: Create todos without status on status field
    Given POST Create new todos with id 3615562 and JSON "CreateTodosStatus.json"
    When Send request POST Create new todos
    Then Status code should be 422 Unprocessable Entity
    And Response body should be show error message "can't be blank, can be pending or completed"
    And Validate todos feature with JSON Schema "CreateTodosStatusShcema.json"

  Scenario: Create todos without tittle on body request
    Given POST Create new todos with id 3615562 and JSON "CreateTodosTitle.json"
    When Send request POST Create new todos
    Then Status code should be 422 Unprocessable Entity
    And Response body should be show error message "can't be blank"
    And Validate todos feature with JSON Schema "CreateTodosTitleShcema.json"


