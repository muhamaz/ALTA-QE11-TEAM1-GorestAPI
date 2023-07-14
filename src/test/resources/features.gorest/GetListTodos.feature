Feature: Get list todos


  Scenario: Get list todos with valid parameter
    Given GET list user with parameter "todos"
    When Send request GET list todos
    Then Status code should be 200 OK
    And Validate todos feature with JSON Schema "ListTodosSchema.json"


  Scenario: Get list todos with invalid parameter
    Given GET list user with parameter "todo"
    When Send request GET list todos
    Then Status code should be 404 Not Found