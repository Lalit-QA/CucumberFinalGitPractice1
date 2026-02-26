@SearchTest
Feature: Google Search

  Scenario: Search for Selenium on Google
    Given user is on Google
    When user searches for "Selenium"
    Then user clicks the first search result
