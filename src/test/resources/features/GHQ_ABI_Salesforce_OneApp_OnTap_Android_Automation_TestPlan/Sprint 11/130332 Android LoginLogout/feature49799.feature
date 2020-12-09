@49799 @iOS @OnTap @regression
Feature: Logout option on Main Menu on OnTap app
	As a BDR
	I want to have a Main Menu in the App
	So I can navigate and select functionalities and screens


	Scenario Outline: Logout option on Main Menu on OnTap app
	  Given I am logged in OnTap as a "<profile>"
	  And I am on the OnTap main page
	  When I click on the side menu button
	  Then The logout option should be displayed in the menu

	  
	  Examples:
		|profile|
		|BDR User| 