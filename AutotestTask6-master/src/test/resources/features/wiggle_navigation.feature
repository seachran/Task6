Feature: Navigation and interaction with Wiggle brand catalog

  Scenario: User navigates to Adidas brand, interacts with filters and verifies pagination
    Given User is on the Wiggle home page
    When User navigates to the "Brands" section
    And User selects the first brand in the list (Adidas)
    Then Adidas brand page is displayed
    When User collapses the left filter panel
    Then The filter panel should be collapsed
    When User expands the left filter panel
    And User sorts products by "Price (High To Low)"
    Then Products should be sorted by high price
    When User scrolls to the bottom of the page
    Then Pagination controls should be visible
    When User navigates back to the home page
    Then Brands section should be visible on the main menu