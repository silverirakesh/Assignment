Feature: Footer Links Validation on DP2 Home Page

@TC4
  Scenario: Verify Footer Links and Report Duplicates
    Given User navigates to the DP2 home page
    When User extracts all hyperlinks from the footer into a CSV file
    Then User verifies if any duplicate hyperlinks are present in the report
 
