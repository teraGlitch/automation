@58367 @Android @iOS @OnTap @ignore @regression
Feature: Successfully Check Out Validation
	As anAutomation Developer
	I wantto automate the Check-in/Check-out to a POC
	So thatthe BDR will be able to do the activities at the POC


	Scenario Outline: Successfully Check Out Validation
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a visit to perform 
	  And I open the visit 
	  And I did the check in successfully 
	  And I did the check out successfully 
	  When I am back to the app main page 
	  Then My visit will have a completed layout 


	 Examples:
		|profile|
		|BDR User| 