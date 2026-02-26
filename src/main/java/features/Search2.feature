@SearchTest
Feature: Google Search

  Scenario: Search for Selenium on Google
    Given user2 is on Google
    When user2 searches for "Selenium"
#    Then user2 clicks the first search result
