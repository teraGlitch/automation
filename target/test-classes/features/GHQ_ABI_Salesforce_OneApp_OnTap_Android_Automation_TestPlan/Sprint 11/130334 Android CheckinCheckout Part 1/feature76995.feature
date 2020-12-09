@76995 @Android @iOS @OnTap @ignore @regression
Feature: Cancel the Check In Within the POC Allowed Distance
	As a BDR
	I want to be prompted if I am sure that I want to check-in/check-out from a POC
	So that I don't accidentally execute the action in a POC.

	Scenario Outline: Cancel the Check In Within the POC Allowed Distance
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a visit to perform 
	  And I open the visit 
	  And I am within the POC visit allowed check in range 
	  When I click on check in button 
	  Then I am able to cancel the check in in this POC 

	 Examples:
		|profile|
		|BDR User| 