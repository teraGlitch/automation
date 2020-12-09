@110920 @Android @iOS @OnTap @ignore @regression
Feature: Validate the Exception for Check in for a Visit already completed
	As anAutomation Developer
	I wantto automate the Check-in/Check-out to a POC
	So thatthe BDR will be able to do the activities at the POC

	Scenario Outline: Validate the Exception for Check in for a Visit already completed
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a completed visit in the list 
	  And I open the visit 
	  When I select the Exceptions option 
	  Then A warning about the completed visit should be displayed 

	 Examples:
		|profile|
		|BDR User| 