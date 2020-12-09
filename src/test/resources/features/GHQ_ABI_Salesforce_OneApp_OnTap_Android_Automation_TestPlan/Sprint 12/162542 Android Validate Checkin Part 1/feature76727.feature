@76727 @iOS @OnTap @ignore @regression
Feature: Validate the Check In Within Allowed Range for Phone Call Visit Type
	As anAutomation Developer
	I wantto automate the Check-in/Check-out to a POC
	So thatthe BDR will be able to do the activities at the POC


	Scenario Outline: Validate the Check In Within Allowed Range for Phone Call Visit Type
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a "<visit>" visit to perform 
	  And I am within the POC visit allowed check in range
	  And I open the visit 
	  When I try to perform the check in 
	  Then I will be able to check in in Phone Call type visits 


	 Examples:
		|profile|visit|
		|BDR User|Phone Call| 