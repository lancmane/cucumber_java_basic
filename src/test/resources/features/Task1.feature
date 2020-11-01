Feature: Number input field

  Background:
    Given I am on the enter number page

  @debugs
  Scenario Outline: Invalid input
    When I enter "<value>"
    And I click submit
    Then I should see error "<message>"

    @not_working
    Examples:
      | value | message             |
      |1      |Number is too small  |
      |49     |Number is too small  |
      |101    |Number is too big    |
      |qwe    |Please enter a number|

  @debugs
  Scenario Outline: Valid input
    When I enter "<value>"
    And I click submit
    Then I should see "<result>"

    @working
    Examples:
    |value|result                     |
    |100  |Square root of 100 is 10.00|
    |50   |Square root of 50 is 7.07  |

  Scenario: Valid number
    When I enter 81
    And I click submit
    Then I should see "Square root of 81 is 9.00"