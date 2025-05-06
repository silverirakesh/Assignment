Feature: Validate slides on DP1 home page

  @TC3
  Scenario: Count number of slides below Tickets Menu
    Given I am on the DP1 home page
    When I locate the slides below the Tickets Menu
    And I should see exactly "<expectedSlideCount>" slides
    And the title should match expected test data
    And the duration should match expected values