Feature: Task 2 Person job list

@debugs
Scenario: Check add person
    Given I am on the people list page using PO
    When I click Add person using PO
    Then Add person page should open using PO

@debugs
Scenario Outline: Adding person
    Given I am on the people list page using PO
    And I check initial list size
    When I open the add person page using PO
    And I enter name "<name>" using PO
    And I enter job "<job>" using PO
    And I click Add using PO
    Then Initial page should open using PO
    When I check new list size
#    Then There is one person more in the list
    And Person name "<name>" and job "<job>" appear in the list using PO
    When I click reset button
    Then Person name "<name>" and job "<job>" do not appear in the list using PO
    And List size should be default
    And Person names should be default
  Examples:
      | name  | job      |
      | Anna  | Engineer |


Scenario Outline: Editing person
    Given I am on the people list page using PO
  #    And I check person ID "<id>" in the list
    And Person name "<name>" and job "<job>" appear in the list using PO
    When I click Edit by ID "<id>"
    Then Edit person page by ID value "<idvalue>" should open using PO
    When I enter new name "<newname>" using PO
    And I enter new job "<newjob>" using PO
    And I click the Edit button
    Then Initial page should open using PO
    And Person name "<name>" and job "<job>" do not appear in the list using PO
    And Person name "<newname>" and job "<newjob>" appear in the list using PO
    When I click reset button
    Then Person name "<newname>" and job "<newjob>" do not appear in the list using PO
    And List size should be default
    And Person names should be default
    Examples:
      |  id    |idvalue| name    | job          | newname | newjob |
      | person0|0      |Mike     |  Web Designer|Jason    |  Doctor|



Scenario Outline: Removing person
    Given I am on the people list page using PO
    And I check initial list size
#    And I check person ID "<id>" in the list
    And Person name "<name>" and job "<job>" appear in the list using PO
    When I click remove by ID "<id>"
    And I check new list size
#    Then There is one person less in the list
    And Person name "<name>" and job "<job>" do not appear in the list using PO
    When I click reset button
    Then List size should be default
    And Person names should be default
  Examples:
    |  id    | name |  job  |
    | person1| Jill |Support|


  Scenario Outline: Check clear button
   Given I am on the add person page using PO
   And All fields are clear
   When I enter name "<name>" using PO
   And I enter job "<job>" using PO
#   Then Name "<name>" and job "<job>" values appear in the fields
   When I click clear button
   Then All fields are clear
   Examples:
     | name  | job     |
     |William|Assistant|














