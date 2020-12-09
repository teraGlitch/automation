@156708 @regression
Feature: Validate Permission Required Message After Allow All Permissions and Deny a Permission in App Settings
	As anAutomation Developer
	I want to automate the Access Permission on OnTap app
	So thatthe BDR will be able to access the OnTap system


	Scenario Outline: Validate Permission Required Message After Allow All Permissions and Deny a Permission in App Settings
	  Given I am logged in OnTap as a "<profile>" 
	  And I am on the OnTap main page
	  When I remove a "<permission>" on app settings 
	  And I back to the app 
	  Then The app displays me a pop up for allow the "<permission>" 
	  And I can accept the denied permission again 


	 Examples:
		|profile|permission|
		|BDR User|Camera|
		|BDR User|Contacts|
		|BDR User|Files|
		|BDR User|Location|
		|BDR User|Phone|