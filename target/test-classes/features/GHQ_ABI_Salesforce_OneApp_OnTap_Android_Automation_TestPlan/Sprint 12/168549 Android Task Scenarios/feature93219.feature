@93219 @Android @OnTap @ignore @regression
Feature: Task Assortment
	New UI Implementation


	Scenario Outline: Task Assortment
	  Given I am logged in OnTap as a "<profile>" 
	  And I am at the open Task Detail page 
	  When I verify the Tasks Card 
	  Then I can see the newest task is always on the top from new to old


	 Examples:
		|profile|
		|BDR User| 