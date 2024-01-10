Feature: Login Flow Test Suite

  @Regression

  Scenario Outline: Validate that the user is not able to login with invalid data
    Given CustomerLoginPage is displayed
    When populate the following fields on the 'CustomerLoginPage'
      | emailCustomerLoginPage    | <email>    |
      | passwordCustomerLoginPage | <password> |
    And click on the 'signInButtonLoginPage' button on the "CustomerLoginPage"
    Then the 'error' messages is displayed on the "CustomerLoginPage"
    Examples:
      | email             | password       |
      | randomEmail       | 21656dasd@     |
      | vasilee@gmail.com | randomPassword |
      | randomEmail       | asdas515aA     |
      | randomEmail       | randomPassword |




