# Gherkin language has specific rules that we need to follow
  # hashtag is a comment
  # first keyword in feature file should be Feature
  # Feature: is a title of feature file
  # feature is a like one test class
  # one feature file will consist all test cases related to one particular functionality

Feature: Deposit test
    # We also have an ability to add more explanation about this feature file
  Here we would write extra explanation about our Feature file

  # Scenario is like 1 test case
  Scenario: We give scenario name here

      # Given is used to define pre conditional steps
      # Given sentences should be in past tense
    Given Bank account 1 exists with balance $1000
      # When is used to define action steps. We call the functionality that we are testing
    When Banl account 1 deposits $100
      # Then is used for validation
    Then Bank account 1 should have $1100 in balance


  Scenario: Money transfer with enough balance
    Given User  account number 123456 is registered
        # And keyword helps to avoid repeating the same words
    And  User  account number 123456 deposited $500
    When User with account number 123456 transferred $300
    And  User with account number 123456 transferred $200
    When User with account number 123456 should have $0 in the balance.