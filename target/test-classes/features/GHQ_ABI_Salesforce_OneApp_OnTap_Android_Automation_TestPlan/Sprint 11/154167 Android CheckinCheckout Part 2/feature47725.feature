@47725 @Android @iOS @OnTap @ignore @regression
Feature: Change button label after check in
	As an OnTap user
	I want to Check-In/Check-out from a POC
	So I can complete the necessary activities for my Visit
	
	Mandatory Tasks: SF has an option called Mandatory Tasks that are used to ensure that the user complete a set of tasks before being able to check-out.


	Scenario Outline: Change button label after check in
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a visit to perform 
	  And I open the visit 
	  And I did the check out successfully 
	  When I try to perform the check in 
	  Then The label will change to check out 


	 Examples:
		|profile|
		|BDR User|