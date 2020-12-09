@93217 @Android @OnTap @ignore @regression
Feature: Task Details
	New UI Implementation


	Scenario Outline: Task Details
	  Given I am logged in OnTap as a "<profile>" 
	  And I am at the open Task Detail page 
	  And I scroll through the Page 
	  Then I can see the Dynamic Layout that came from SF with all the revelant Tasks Details. 


	 Examples:
		|profile|
		|BDR User| 