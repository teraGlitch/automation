@156671  @regression
Feature: Validate and Allow Permission Messages
	As anAutomation Developer
	I want to automate the Access Permission on OnTap app
	So thatthe BDR will be able to access the OnTap system


	Scenario Outline: Validate and Allow Permission Messages
	  Given I have logged on OnTap App with the "<profile>" for the first time 
	  And The first sync is finished 
	  When I allow all the permissions until I find "<permission>" pop up 
	  Then I can allow the permission 


	 Examples:
		|profile|permission|
		|BDR User|Contacts|
		|BDR User|Files|
		|BDR User|Camera|
		|BDR User|Location|
		|BDR User|Phone| 