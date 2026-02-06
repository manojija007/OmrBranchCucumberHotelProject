@TC002
Feature: Search Hotel Functionality
  As a  user
  I want to search hotel in to the application
  So that I can see all hotel information

  #Scenario: User logs in with valid credentials
  #Given User enters a valid email address "manojija007@gmail.com" in the email field
  #And User enters a valid password "Liyanshi@107" in the password field
  #And User clicks the login button
  #Then User should be successfully logged in
  #And User navigates to Hotel page
  Scenario: Search hotels with all fields
    Given User enters a valid email address "manojija007@gmail.com" in the email field
    And User enters a valid password "Liyanshi@107" in the password field
    And User clicks the login button
    And User click the Book Hotel option
    And User searches hotels using below fields
      | State          | Tamil Nadu |
      | City           | Madurai    |
      | Room type      | Deluxe     |
      | Check in date  | 2026-02-10 |
      | Check out date | 2026-02-12 |
      | No of Rooms    | 2-Two      |
      | No of Adults   | 4-Four     |
      | No of Children |          2 |
    And User click search button
    Then User should verify showing all hotel list "Select Hotel"
