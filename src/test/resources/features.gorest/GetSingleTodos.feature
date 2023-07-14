Feature: Get Single Todos

  Scenario: Get Single todos with valid parameter id
    Given GET Single todos with parameter id 20226
    When Send request GET Single todos
    Then Status code should be 200 OK
    And Validate todos feature with JSON Schema "SingleTodosSchema.json"

  Scenario: Get Single todos with invalid parameter id
    Given GET Single todos with parameter id 999999
    When Send request GET Single todos
    Then Status code should be 404 Not Found
    And Validate todos feature with JSON Schema "SingleTodosInvalidSchema.json"
