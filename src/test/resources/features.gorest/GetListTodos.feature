Feature:

Scenario: Get list Todos with valid parameter path
  Given Get list todos with valid parameter "todos"
  When Send get list todos
  Then Status code should be 200 OK
  And Validate with JSON Schema valid parameter

Scenario: Get list todos with unvalid parameter path
  Given Get list todos with unvalid parameter "todo"
  When Send get list todos
  Then Status code should be 404 not found