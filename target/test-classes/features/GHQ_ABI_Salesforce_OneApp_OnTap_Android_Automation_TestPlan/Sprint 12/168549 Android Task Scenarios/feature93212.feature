@93212 @Android @OnTap @ignore @regression
Feature: Task List Page
	New UI Implementation


	Scenario Outline: Task List Page
	  Given I am logged in OnTap as a "<profile>" 
	  And I go to Task Page in User 360 
	  Then I can see a list of all the Tasks opened 
	  And verify that each card has dynamic layout 


	 Examples:
		|profile|
		|BDR User| 