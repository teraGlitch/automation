@82968 @Android @OnTap @ignore @regression
Feature: Save and Syncronized the all the tasks information
	New UI Implementation


	Scenario Outline: Save and Syncronized the all the tasks information
	  Given I am logged in OnTap as a "<profile>" 
	  And I am at the open Task Detail page 
	  When I am create new Task with all the information added 
	  Then all the information are ready to be synchronized. 


	 Examples:
		|profile|
		|BDR User| 