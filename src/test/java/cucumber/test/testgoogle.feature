Feature: Testing for java in GooglePage

  Scenario: Search Java in Google Page
    Given Open Google page in firefox
    When I type java in search field
    And I click on search button
    Then I see results for java
