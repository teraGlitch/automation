@66404 @Android @CriticalPath @OnTap @regression
Feature: Login on Android device
	


	Scenario Outline: OnTap Android Login
	  Given I have opened the OnTap app
	  And The Salesforce authentication page is displayed
	  And I enter the credentials for "<profile>"
	  When I click on login button
	  And The system finished syncing
	  Then I will be at OnTap main page
	  
	  
	 Examples:
		|profile|
		|BDR User| 