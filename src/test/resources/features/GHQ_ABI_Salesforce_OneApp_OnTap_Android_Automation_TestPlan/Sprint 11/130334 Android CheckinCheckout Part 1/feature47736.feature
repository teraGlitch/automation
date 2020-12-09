@47736 @iOS @OnTap @ignore @regression
Feature: Visits Counter Update After Check Out
	As an OnTap user
	I want to Check-In/Check-out from a POC
	So I can complete the necessary activities for my Visit
	
	Mandatory Tasks: SF has an option called Mandatory Tasks that are used to ensure that the user complete a set of tasks before being able to check-out.

	Scenario Outline: Visits Counter Update After Check Out
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a visit to perform 
	  And I open the visit 
	  And I did the check in successfully 
	  When I back to OnTap main page 
	  Then The complete visits counter will be increased 
	  And The open visits counter will be decreased 

	 Examples:
		|profile|
		|BDR User| 