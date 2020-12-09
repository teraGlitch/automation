@58372 @Android @iOS @OnTap @ignore @regression
Feature: Validate Check In Exceptions
	As anAutomation Developer
	I wantto automate the Check-in/Check-out to a POC
	So thatthe BDR will be able to do the activities at the POC


	Scenario Outline: Validate Check In Exceptions
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a visit to perform 
	  And I open the visit 
	  And The check in button is being displayed 
	  When I click on exceptions option 
	  And I apply an "<exceptionOption>" for the exception 
	  Then The app will sync the changes 
	  And The visit should not be completed 


	 Examples:
		|profile|exceptionOption|
		|BDR User|Final Closed Client|
		|BDR User|Duplicate client|
		|BDR User|Georeference Error| 