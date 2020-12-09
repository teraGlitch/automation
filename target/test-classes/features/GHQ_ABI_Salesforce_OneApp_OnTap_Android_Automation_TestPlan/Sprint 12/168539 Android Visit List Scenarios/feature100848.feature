@100848 @Android @DO @iOS @OnTap @regression
Feature: Global Search Bar on the Unplanned Visit Page
  As a BDR
  I want to have a Search Tool Bar in the Visit List
  So that I can find Accounts in the visit list by typing the Account name or SAP ID
  
  **First Phase - Sprint 18 - 28/10**
  
  First phase will be an Account search only in the Visit list

  Scenario Outline: Global Search Bar on the Add Client Page
    Given I am logged in OnTap as a "<profile>"
    And I am on the OnTap main page
    When I access the add new client screen
    Then The app will list the POCs available to schedule an unplanned visit
    And The Global Search Bar will be at the top of the screen

    Examples: 
      | profile  |
      | BDR User |
