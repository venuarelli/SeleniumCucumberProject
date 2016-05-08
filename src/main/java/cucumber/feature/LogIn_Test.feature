Feature: Login Functionality Feature
  
  In order to ensure Login Functionality works,
  I want to run the cucumber test to verify it is working

  @positiveScenario
  Scenario: Login Functionality
    Given user navigates to SOFTWARETETINGHELP.COM
    When user logs in using Username as “USER” and Password “PASSWORD”
    Then login should be successful

  @negaviveScenario
  Scenario: Login Functionality
    Given user navigates to SOFTWARETETINGHELP.COM
    When user logs in using Username as “USER1” and Password “PASSWORD1”
    Then error message should throw
