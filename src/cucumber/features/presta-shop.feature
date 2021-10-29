Feature: New Address

  Scenario Outline: add a new address

    Given user is logged in to Presta-Shop
    When user goes to Addresses
    And user clicks add new address
    Then user fills "<alias>" as Alias, "<address>" as Address, "<zip>" as Zip, "<city>" as City, "<phone>" as Phone
    And user clicks 'Save' button
    Then "Address successfully added!" is displayed

    Examples:
      |alias|address   |zip    |city    |phone |
      |John |StanStreet|06-567 |London  |094535|