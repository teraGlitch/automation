@47734 @Android @iOS @OnTap @ignore @regression
Feature: Check In to a Different POC With Another Visit in Progress
	As an OnTap user
	I want to Check-In/Check-out from a POC
	So I can complete the necessary activities for my Visit
	
	Mandatory Tasks: SF has an option called Mandatory Tasks that are used to ensure that the user complete a set of tasks before being able to check-out.

	Scenario Outline: Check In to a Different POC With Another Visit in Progress
	  Given I am logged in OnTap as a "<profile>" 
	  And I have two visits to perform 
	  And I do the check in in the first POC 
	  When I open the second visit 
	  Then A message about the current check in is displayed 
	  And I am able to check out the current visit and check in in the second 

	 Examples:
		|profile|
		|BDR User| 