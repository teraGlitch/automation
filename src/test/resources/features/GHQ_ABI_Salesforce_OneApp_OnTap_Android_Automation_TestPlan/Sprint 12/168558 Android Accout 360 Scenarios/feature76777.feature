@76777 @Android @OnTap @ignore @regression
Feature: Order the Icons on the Slider selection to Account 360 Page
  As anAutomation Developer
  I wantTo automate the Account 360 scenariosSo thatThe BDR will be able to use the OnTap system

  Scenario Outline: Order the Icons on the Slider selection to Account 360 Page
    Given I am logged in OnTap as a "<profile>"
    And I am on the OnTap main page
    When I see the Action Icons above the Check In button
    Then the icons should be order by: POC Insights KPI 360 Timeline Chatter Notes

    Examples: 
      | profile  |
      | BDR User |
