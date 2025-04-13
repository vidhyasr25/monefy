@E2E
Feature: Add new income record

  @addIncome
  Scenario Outline: Verification of new addition of an income

    Given app is launched on the device using the package "com.monefy.app.lite" and uuid of the device "<device uuid>"
    And user navigates to the home screen with pie chart
    Then user adds a new income

    Examples:
      | device uuid   |
      | emulator-5556 |

  @addExpense
  Scenario Outline: Verification of new addition of an expense

    Given app is launched on the device using the package "com.monefy.app.lite" and uuid of the device "<device uuid>"
    And user navigates to the home screen with pie chart
    Then user adds a new expense

    Examples:
      | device uuid   |
      | emulator-5556 |

  @deleteExpense
  Scenario Outline: Verification of deletion of an expense

    Given app is launched on the device using the package "com.monefy.app.lite" and uuid of the device "<device uuid>"
    And user navigates to the home screen with pie chart
    And user adds a new expense
    Then user deletes a new expense

    Examples:
      | device uuid   |
      | emulator-5556 |