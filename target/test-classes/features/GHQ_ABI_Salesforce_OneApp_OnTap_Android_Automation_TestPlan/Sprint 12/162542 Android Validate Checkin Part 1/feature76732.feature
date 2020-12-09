@76732 @iOS @OnTap @regression
Feature: Validate the Check In Alert When Outside of Allowed Range for Planned Visit Visits
	As a Backoffice user
	I want to control whether I want to block or not the Check-in of a BDR if he/she is not in range
	So that I can change the configuration according to my business needs


	Scenario Outline: Validate the Check In Alert When Outside of Allowed Range for Planned Visit Visits
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a "<visit>" visit to perform 
	  And I open the visit 
	  And I am oustide of the POC visit allowed check in range 
	  When I try to perform the check in 
	  Then The system displays a message about the range allowed for Planned Visit visits 


	 Examples:
		|profile|visit|
		|BDR User|Planned Visit| 