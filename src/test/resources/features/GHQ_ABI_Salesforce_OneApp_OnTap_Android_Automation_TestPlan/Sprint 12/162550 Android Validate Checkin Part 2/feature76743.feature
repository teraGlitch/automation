@76743 @iOS @OnTap @ignore @regression
Feature: Alert Message in a Already Completed Visit
	As a Backoffice user
	I want to control whether I want to block or not the Check-in of a BDR if he/she is not in range
	So that I can change the configuration according to my business needs


	Scenario Outline: Alert Message in a Already Completed Visit
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a completed visit in the list 
	  And I open the visit 
	  When I click on check in button 
	  Then The system should display a message informing already completed visit 


	 Examples:
		|profile|
		|BDR User| 