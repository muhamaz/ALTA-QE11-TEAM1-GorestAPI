Feature: Delete user

  Scenario: Delete user with valid id user
    Given DELETE User with valid parameter id 3644022
    When Send request DELETE User
    Then Status code should be 204 No Content

  Scenario: Delete user with invalid id user
    Given DELETE User with valid parameter id 1
    When Send request DELETE User
    Then Status code should be 404 Not Found
    And Response body should be display eror mesage "Resource not found"