@76997 @Android @iOS @OnTap @ignore @regression
Feature: Confirm the Check Out Within the POC Allowed Distance
	As a BDR
	I want to be prompted if I am sure that I want to check-in/check-out from a POC
	So that I don't accidentally execute the action in a POC.


	Scenario Outline: Confirm the Check Out Within the POC Allowed Distance
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a visit to perform
	  And I open the visit
	  And I did the check in successfully 
	  When I click on check out button 
	  Then I am able to check out this visit 


	 Examples:
		|profile|
		|BDR User|