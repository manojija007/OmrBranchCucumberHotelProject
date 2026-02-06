@TC001
Feature: Login Account Functionality
  As a registered user
  I want to log in to the application
  So that I can access my account

  Scenario: User logs in with valid credentials
    Given User enters a valid email address "manojija007@gmail.com" in the email field
    And User enters a valid password "Liyanshi@107" in the password field
    And User clicks the login button
    Then User should be successfully logged in
    #And User navigates to Hotel page

  Scenario: User logs in with invalid email and valid password
    Given User enters a Invalid email address "manojija7@gmail.com" in the email field
    And User enters a valid password "Liyanshi@107" in the password field
    And User clicks the login button
    Then User should see an error message for Invalid email "User does not exist"

  Scenario: User logs in with valid email and invalid password
    Given User enters a valid email address "manojija007@gmail.com" in the email field
    And User enters a Invalid password "Liyanshi@7" in the password field
    And User clicks the login button
    Then User should see an error message for Invalid password "Invalid Login details or Your Password might have expired"

  Scenario: User tries to log in without any credentials
    Given User does not enter an email address in the email field
    And User does not enter a password in the password field
    And User clicks the login button
    Then User should see validation error messages
