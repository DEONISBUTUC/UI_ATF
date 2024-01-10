Feature: Get actions

  @Run
  Scenario: Validate that the home page displays Most Popular and Recently viewed products

    Given the user navigates to the Home Page with POST request containing the following parameters:
      | mostPopular    | true |
      | recentlyViewed | true |
    And the response status code is '200'
    And 'Most Popular' and 'Recently Viewed' products are displayed

    When the user clicks on the Laptops on the bar menu

    Then the user is redirected to the Laptops page
    And the response status code is '200'
    And the following product details are displayed:
      | ASUS 15.6 Gaming A15 16GB/512GB | 26499 |
      | Lenovo 15Idea Gaming 3 16/1TB   | 21499 |
      | Lenovo 16IdeaPad Sl 5 16/1TB    | 19499 |


