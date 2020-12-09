@58370 @Android @iOS @OnTap @ignore @regression
Feature: Validate Check Out Exceptions
	As anAutomation Developer
	I wantto automate the Check-in/Check-out to a POC
	So thatthe BDR will be able to do the activities at the POC


	Scenario Outline: Validate Check Out Exceptions
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a visit to perform 
	  And I open the visit 
	  And I did the check in successfully 
	  When I click on exceptions option 
	  And I apply an "<exceptionOption>" for the exception 
	  Then The app will sync my changes 
	  And The check out will be done successfully 


	 Examples:
		|profile|exceptionOption|
		|BDR User|Final Closed Client|
		|BDR User|Duplicate client|
		|BDR User|Georeference Error| 