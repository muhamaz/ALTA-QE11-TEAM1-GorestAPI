Feature: Update Todos

  Scenario: Update todos with valid id
    Given PUT Update todos with id 20226 and JSON "UpdateTodos.json"
    When Send request PUT Update todos
    Then Status code should be 200 OK
    And Validate todos feature with JSON Schema "UpdateTodosSchema.json"

  Scenario: Update todos with invalid id
    Given PUT Update todos with id 99999 and JSON "UpdateTodos.json"
    When Send request PUT Update todos
    Then Status code should be 404 Not Found
    And Response body should be display errr msg "Resource not found"
    And Validate todos feature with JSON Schema "UpdateTodosInvalidSchema.json"

  Scenario: Update todos without title
    Given PUT Update todos with id 20226 and JSON "UpdateTodosTitle.json"
    When Send request PUT Update todos
    Then Status code should be 422 Unprocessable Entity
    And Response body should be display err msge "can't be blank"
    And Validate todos feature with JSON Schema "UpdateTodosTitleSchema.json"