@47731 @Android @iOS @OnTap @ignore @regression
Feature: Change button label after check out
	As an OnTap user
	I want to Check-In/Check-out from a POC
	So I can complete the necessary activities for my Visit
	
	Mandatory Tasks: SF has an option called Mandatory Tasks that are used to ensure that the user complete a set of tasks before being able to check-out.


	Scenario Outline: Change button label after check out
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a visit to perform 
	  And I open the visit 
	  And I did the check in successfully 
	  When I try to perform the check out 
	  Then The label will change to check in 


	 Examples:
		|profile|
		|BDR User|