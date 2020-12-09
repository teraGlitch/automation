@54845 @Android @OnTap @ignore @regression
Feature: Reschedule a visit for the next week
	As a BDR
	I want to reschedule a visit for the same week
	So that in case a POC is closed, or I am unable to visit it, I can still complete the assignment


	Scenario Outline: Reschedule a visit for the next week
	  Given I am logged in OnTap as a "<profile>" 
	  And I am on the OnTap main page 
	  And I have a "<visit>" visit to perform 
	  When I choose a visit "<visit>" to Reschedule in the next week 
	  Then the app will deny this action


	 Examples:
		|profile|visit|
		|BDR User|Planned Visit| 