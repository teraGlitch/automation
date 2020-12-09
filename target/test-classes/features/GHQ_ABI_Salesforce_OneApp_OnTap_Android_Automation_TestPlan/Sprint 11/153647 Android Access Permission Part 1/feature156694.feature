@156694 @Automation @OnTap @regression
Feature: Deny Permissions and Validate Permission Required Messages
  As anAutomation Developer
  I want to automate the Access Permission on OnTap app
  So thatthe BDR will be able to access the OnTap system

  Scenario Outline: Deny Permissions and Validate Permission Required Messages
    Given I have logged on OnTap App with the "<profile>" for the first time
    And The first sync is finished
    When I allow all the permissions excluding "<permission>"
    Then The message about permission required is displayed
    And I cannot access the app until the "<permission>" is allowed

    Examples: 
      | profile  | permission |
      | BDR User | Contacts   |
      | BDR User | Files      |
      | BDR User | Camera     |
      | BDR User | Location   |
      | BDR User | Phone      |
