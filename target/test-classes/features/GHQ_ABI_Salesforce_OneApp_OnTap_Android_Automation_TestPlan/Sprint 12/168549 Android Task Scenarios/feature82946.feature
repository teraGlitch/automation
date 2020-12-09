@82946 @Android @OnTap @ignore @regression
Feature: Task edition
	New UI Implementation


	Scenario Outline: Task edition
	  Given I am logged in OnTap as a "<profile>" 
	  And I am at the open Task Detail page 
	  When I click on Edit button 
	  Then I am taken to the Task Edit page where I can edit change the information

	 Examples:
		|profile|
		|BDR User| 