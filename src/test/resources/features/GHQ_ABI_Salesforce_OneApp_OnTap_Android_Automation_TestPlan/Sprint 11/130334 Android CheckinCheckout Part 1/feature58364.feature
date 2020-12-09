@58364 @Android @iOS @OnTap @ignore @regression
Feature: Check In Outside of POC Allowed Distance
	As anAutomation Developer
	I wantto automate the Check-in/Check-out to a POC
	So thatthe BDR will be able to do the activities at the POC


	Scenario Outline: Check In Outside of POC Allowed Distance
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a visit to perform 
	  And I open the visit 
	  And I am oustide of the POC visit allowed check in range 
	  When I try to perform the check in 
	  Then The app displays an error message informing that I am out of the allowed distance 
	  And I am able to cancel the check in 


	 Examples:
		|profile|
		|BDR User| 