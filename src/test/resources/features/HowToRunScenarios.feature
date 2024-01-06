Feature: Transfer

  Scenario: Money transfer with insufficient fund
    Given User with account number 4210 is registered
    And  User with account number 4210 deposited $1000
    When User with account number 4210 transfers $1100
    Then User with account number 4210should have $1000 in balance
    And User should see Insufficient Funds message


