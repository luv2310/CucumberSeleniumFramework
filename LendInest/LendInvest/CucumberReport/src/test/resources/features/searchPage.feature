Feature: Feature to run ebay search result scenario's

  Scenario: Search and verify results
    Given I am a non-registered customer
    And I navigate to www.ebay.co.uk
    When I search for an item
    Then I get a list of matching results
    And the resulting items cards show: postage price, No of bids,price or show BuyItNow tag
    Then I can sort the results by Lowest Price
    And the results are listed in the ascending in the correct order
    Then I can sort the results by Highest Price
    And the results are listed in the descending in the correct order
    Then I can filter the results by mBuy it nowm
    And all the results shown in the page have the mBuy it nowm tag
