Feature: File uploading functionality
  
  As an automation test engineer,
  I want to test all the file uploading scenarios,
  So that exceptions will be generated as expected
  Rule: User should not be able to register with existing email id

  @Tagss
  Scenario: Validate whether the user is able to register with the username that was already created earlier
    Given I am on registration page
    When I register with the existing email id in the database
    Then registration should not be successful
    And I see field level error message at email field

  Scenario: User is not able to test test
    Given I test dependency injection
