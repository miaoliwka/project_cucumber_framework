Feature: Presta Shop operations

  Scenario: buying five blouses

    Given user logged in to Presta-Shop
    When user clicks 'clothes' button
    And user selects product Hummingbird Printed Sweater
    And user clicks 'size' button and selects 'm' size
    And user selects five items
    When user adds product to cart and clicks 'proceed to checkout' twice
    And user confirm address by 'continue' button
    And user selects shipping method 'pick up in store' and clicks 'continue' button
    And user selects payment option 'pay by check' and agree the terms
    And user clicks 'order with an obligatory to pay' button
    Then user makes order screenshot