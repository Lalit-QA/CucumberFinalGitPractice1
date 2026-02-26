@LoginTestCSV
Feature: Login using CSV data

  Scenario Outline: Validate login with csv data
    Given user is on login page
    When user logs in using csv row "<row>"
    Then login should be "<result>"

    Examples:
      | row | result  |
      | 1   | success |
      | 2   | failure |
      | 3   | failure |