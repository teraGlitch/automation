@57197 @Android @OnTap @regression
Feature: User 360 wants to Logout from the App
	As anAutomation Developer
	I want to automate the Login/Logout on OnTap app
	So thatthe BDR will be able to access the OnTap system


	Scenario Outline: User 360 wants to Logout from the App
	  Given I am logged in OnTap as a "<profile>"
	  And I am on the OnTap main page
	  And I open the side menu
	  When I click on the logout option
	  And I confirm the logout
	  Then I will be logged out successfully

	  
	  Examples:
		|profile|
		|BDR User| 