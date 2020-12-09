@47719 @Android @iOS @OnTap @ignore @regression
Feature: Validate Check In Without Internet Connection
	As an OnTap user
	I want to Check-In/Check-out from a POC
	So I can complete the necessary activities for my Visit
	
	Mandatory Tasks: SF has an option called Mandatory Tasks that are used to ensure that the user complete a set of tasks before being able to check-out.


	Scenario Outline: Validate Check In Without Internet Connection
	  Given I am logged in OnTap as a "<profile>" 
	  And I am on the OnTap main page
	  And I have a visit to perform 
	  And I open the visit 
	  And I am within the POC visit allowed check in range 
	  And I turn off my cellular data 
	  When I try to perform the check in 
	  Then I am able to check in even with my cellular data turned off 


	 Examples:
		|profile|
		|BDR User| 