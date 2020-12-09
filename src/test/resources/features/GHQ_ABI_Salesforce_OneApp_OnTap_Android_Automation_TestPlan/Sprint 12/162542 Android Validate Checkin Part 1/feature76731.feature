@76731 @iOS @OnTap @ignore @regression
Feature: Validate the Check In Within Allowed Range for Negotiation Visit Type
  As anAutomation Developer
  I wantto automate the Check-in/Check-out to a POC
  So thatthe BDR will be able to do the activities at the POC

  Scenario Outline: Validate the Check In Within Allowed Range for Negotiation Visit Type
    Given I am logged in OnTap as a "<profile>"
    And I have a "<visit>" visit to perform
    And I open the visit
    And I am within the POC allowed check in range
    When I try to perform the check in
    Then I am able to check in Negotiation type visits

    Examples: 
      | profile  | visit       |
      | BDR User | Negotiation |
