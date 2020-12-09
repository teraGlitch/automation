@54846 @Android @OnTap @ignore @regression
Feature: Reschedule a visit with Status different than Open
	As a BDR
	I want to reschedule a visit for the same week
	So that in case a POC is closed, or I am unable to visit it, I can still complete the assignment


	Scenario Outline: Reschedule a visit with Status different than Open
	  Given I am logged in OnTap as a "<profile>" 
	  And I am on the OnTap main page 
	  And I have a "<visit>" visit to perform 
	  When I choose a visit with status "<Status>" to Reschedule 
	  And I select a date in the same week to Reschedule 
	  Then the app will deny the performed action 


	 Examples:
		|Status|profile|visit|
		|Canceled|BDR User|Planned Visit| 