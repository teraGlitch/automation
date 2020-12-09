@76747 @iOS @OnTap @ignore @regression
Feature: Check In in a Completed Visit
	As a Backoffice user
	I want to control whether I want to block or not the Check-in of a BDR if he/she is not in range
	So that I can change the configuration according to my business needs

	Scenario Outline: Check In in a Completed Visit
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a completed visit in the list 
	  And I open the visit 
	  When I try to perform the check in 
	  Then I am able to check in in a already completed visit in the list 

	 Examples:
		|profile|
		|BDR User| 