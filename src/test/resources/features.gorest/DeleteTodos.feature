Feature: Delete Todos

  Scenario: Delete todos with valid id
    Given DELETE todos with valid id 20293
    When Send request DELETE todos
    Then Status code should be 204 No Content

  Scenario: Delete todos with invalid id
    Given DELETE todos with invalid id 9999999
    When Send request DELETE todos
    Then Status code should be 404 Not Found