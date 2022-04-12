Feature: user login and website navigation

  Scenario Outline: user login and website navigation
    Given user is logged into website
    When user clicks an Addresses button
    And user clicks an Create new address button
   When user fills form with data "<alias>", "<address>", "<city>", "<zip>","<country>", "<phone>"
   Then user add a new address
    And user check correctness of fills form


    Examples:
      |alias| address | city  | zip     |country        | phone   |
      |4321 | Milowa  |Warsaw | 00-002  |United Kingdom |123123123|
