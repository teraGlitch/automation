@76960 @OnTap @ignore @regression
Feature: Display POC Insights when I do the Check in
  As a BDR
  I want to have a POC Insights Screen
  So that I can check

  Scenario Outline: Display POC Insights when I do the Check in
    Given I am logged in OnTap as a "<profile>"
    And I have a visit to perform
    And I open the visit
    And I did the check out successfully
    When I try to perform the check in
    Then the POC insights will be displayed as a pop-up

    Examples: 
      | profile  |
      | BDR User |
