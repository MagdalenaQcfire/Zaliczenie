Feature: user makes online shopping

  Scenario: user online shopping
    Given user logs on to website
    When user check a Hummingbird Printed Sweater product
    And user check a Medium size
    When user chooses 5 item of product
    And user add a product to shopping cart
    When user go to option checkout
    And user confirm address
    When user chooses payment option
    And user clicks on order with payment obligation
    Then user take a screenshot of order confirmation

