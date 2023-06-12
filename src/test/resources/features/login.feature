Feature: Login Test- The user should be able to login with valid credentials

  Background: Go to home page
    Given The user is on the login page


  Scenario: Positive scenario 1 loginWithOutParameters-user should be able to login
    When The user enters valid credentials
    Then verify "Welcome etsb5"

  Scenario: Positive scenario 2 loginWithParameters- user should be able to login
    When The user enters with "etsb5" and "Test12345" credentials
    Then verify "Welcome etsb5"

  Scenario Outline: Positive scenario 3 loginWithScenarioOutline- user should be able to login
    When The user enters with "<username>" and "<password>" credentials
    Then verify "<message>"
    Examples:
      | username | password  | message       |
      | etsb5    | Test12345 | Welcome etsb5 |


  Scenario Outline: Positive scenario 4 loginWithDataTableAndScenarioOutline- user should be able to login
    When The user enters valid username and password
      | username | <username> |
      | password | <password> |
    Then verify "<message>"

    Examples:
      | username | password  | message       |
      | etsb5    | Test12345 | Welcome etsb5 |
        #| etsB3    | Test123+ |Welcome etsB3|

  @negativeScenario
  Scenario Outline:Negative scenario 5- user should NOT be able to login with invalid credentials
    When The user enters with "<invalidUsername>" and "<invalidPassword>" credentials
    Then verify invalid credential "<message>"

    Examples:
      | invalidUsername | invalidPassword | message                                |
      | etsb5           | invalidPassword | Wrong password.                        |
      | etsb5invalid    | Test12345       | User does not exist.                   |
      | etsb5invalid    | invalidPassword | User does not exist.                   |
      |                 | Test12345       | Please fill out Username and Password. |
      | etsb5           |                 | Please fill out Username and Password. |
      |                 |                 | Please fill out Username and Password. |