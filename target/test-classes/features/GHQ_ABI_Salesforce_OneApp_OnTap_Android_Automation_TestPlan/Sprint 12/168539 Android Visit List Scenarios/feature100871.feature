@100871 @Android @DO @iOS @OnTap @ignore @regression
Feature: Account Searching for an Unplanned Visit already on the Visit List for the day
	As a BDR
	I want to have a Search Tool Bar in the Visit List
	So that I can find Accounts in the visit list by typing the Account name or SAP ID
	
	**First Phase - Sprint 18 - 28/10**
	
	First phase will be an Account search only in the Visit list


	Scenario Outline: Account Searching for an Unplanned Visit already on the Visit List for the day
	  Given I am logged in OnTap as a "<profile>" 
	  When I type the name of the POC in the Global Search bar "<account>" 
	  Then the app will apply the filter and will not find the POC that I am looking for 


	 Examples:
		|profile|account|
		|BDR User|COLMADO COLOREDO|
		|BDR User|COLMADO SANTA|
		|BDR User|COLMADO WISENDY| 