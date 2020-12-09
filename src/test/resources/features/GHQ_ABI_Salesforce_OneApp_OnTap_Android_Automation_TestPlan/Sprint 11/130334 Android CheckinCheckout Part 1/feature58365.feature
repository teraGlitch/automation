@58365 @Android @iOS @OnTap @ignore @regression
Feature: Check In Within the POC Allowed Distance
	As anAutomation Developer
	I wantto automate the Check-in/Check-out to a POC
	So thatthe BDR will be able to do the activities at the POC


	Scenario Outline: Check In Within the POC Allowed Distance
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a visit to perform 
	  And I open the visit 
	  And I am within the POC visit allowed check in range 
	  When I try to perform the check in 
	  Then I am able to check in successfully 


	 Examples:
		|profile|
		|BDR User| 