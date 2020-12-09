@156792 @Automation @OnTap @regression
Feature: Validate Displayed Message After Turning Off Location and Not Turn On Back
  As anAutomation Developer
  I want to automate the Access Permission on OnTap app
  So thatthe BDR will be able to access the OnTap system

  Scenario Outline: Validate Displayed Message After Turning Off Location and Not Turn On Back
    Given I am logged in OnTap as a "<profile>"
    When I turn off the device GPS
    And I back to the app
    Then A message about the disabled location is displayed
    And I should be able to keep the location disabled

    Examples: 
      | profile  |
      | BDR User |
