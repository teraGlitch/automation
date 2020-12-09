@100853 @Android @DO @OnTap @regression
Feature: Global Search Bar - Account Searching for an Unplanned Visit
  As a BDR
  I want to have a Search Tool Bar in the Visit List
  So that I can find Accounts in the visit list by typing the Account name or SAP ID
  
  **First Phase - Sprint 18 - 28/10**
  
  First phase will be an Account search only in the Visit list

  Scenario Outline: Search an Account by POC Screen
    Given I am logged in OnTap as a "<profile>"
    And I am on the OnTap main page
    When I type the name of the POC in the Global Search bar "<account>"
    Then the app will apply the filter and bring me the results according

    Examples: 
      | profile  | account          |
      | BDR User | COLMADO WISENDY  |
      | BDR User | COLMADO NORIN    |
      | BDR User | COLMADO COLOREDO |
