@fileupload
Feature: File Upload Functionality

  Scenario: Upload a file successfully
    Given User launches the browser and opens upload page
    When User uploads a file
    Then File should be uploaded successfully
