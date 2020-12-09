@76728 @iOS @OnTap @ignore @regression
Feature: Validate Check In Within Allowed Range for Planned Visit Type
  As anAutomation Developer
  I wantto automate the Check-in/Check-out to a POC
  So thatthe BDR will be able to do the activities at the POC

  Scenario Outline: Validate Check In Within Allowed Range for Planned Visit Type
    Given I am logged in OnTap as a "<profile>"
    And I have a "<visit>" visit to perform
    And I open the visit
    And I am within the POC allowed check in range
    When I try to perform the check in
    Then The check in will be done successfully in my Planned Visit activity

    Examples: 
      | profile  | visit         |
      | BDR User | Planned Visit |
