@76697 @iOS @OnTap @ignore @regression
Feature: Validate the Check-in inside of the range for Phone call visit type
	As anAutomation Developer
	I wantto automate the Check-in/Check-out to a POC
	So thatthe BDR will be able to do the activities at the POC


	Scenario Outline: Validate the Check-in inside of the range for Phone call visit type
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a Phone Call visit to perform 
	  And I open the visit 
	  When I try to perform the check in 
	  Then I am able to check in in Phone Call type visits 

	  Examples:
		|profile|
		|BDR User|