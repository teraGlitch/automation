@112797 @iOS @OnTap @regression
Feature: Logout pop-up option after first sync
	As anAutomation Developer
	I want to automate the Login/Logout on OnTap app
	So thatthe BDR will be able to access the OnTap system


	Scenario Outline: Logout pop-up option after first sync
	  Given I am logged in OnTap as a "<profile>"
	  And The system starts syncing
	  And I turn off the celular data
	  And I get an error message during the first sync
	  And I turn on the celular data
	  When I will click on the logout option in the message
	  Then I will be redirected to Salesforce login page

	  Examples:
		|profile|
		|BDR User|