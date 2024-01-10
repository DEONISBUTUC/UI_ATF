Feature: Register Flow Test Suite

  @Run
  Scenario Outline: Validate that user is able to create an account with valid data
    Given CreateNewCustomer Page is displayed
    When populate the following fields on the 'CreateNewCustomerAccountPage'
      | firstNameField       | <First Name>       |
      | lastNameField        | <Last Name>        |
      | emailField           | <Email>            |
      | passwordField        | <Password>         |
      | confirmPasswordField | <Confirm Password> |
    And click on the 'createAnAccountButton' button on the 'CreateNewCustomerAccountPage'
    Then the 'success' messages is displayed on the 'CreateNewCustomerAccountPage'
    Examples:
      | First Name      | Email       | Last Name      | Password       | Confirm Password      |
      | randomFirstName | randomEmail | randomLastName | randomPassword | randomConfirmPassword |
      | Iuliana         | randomEmail | random         | 02252525aA!    | 02252525aA!           |




