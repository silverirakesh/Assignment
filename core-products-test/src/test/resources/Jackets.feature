Feature: Extract Jacket Details
  As a user
  I want to retrieve all jacket titles, prices, and top seller messages
  So that I can store them in a text file and attach it to the test report
 @TC1
 Scenario: Extract and store jacket details from all pages
    Given User navigates to the Mens Jackets section
    When User extracts jacket details from all paginated pages
    Then User saves jacket details in a text file and attaches it to the report

    
 @TC2   
 Scenario: Hover on menu >> click on New & Features >> Count video feeds
    Given User is on the CP home page
    When User clicks on New & Features
    Then User counts the total number of video feeds available
    And User counts the video feeds that are present on the page which are greater than three days