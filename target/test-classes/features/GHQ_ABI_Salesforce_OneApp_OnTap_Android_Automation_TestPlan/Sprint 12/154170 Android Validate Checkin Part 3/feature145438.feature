@145438 @Android @ignore @regression
Feature: Validate Actions While Background Sync is Active
	As anAutomation Developer
	I wantto automate the Check-in/Check-out to a POC
	So thatthe BDR will be able to do the activities at the POC


	Scenario Outline: Validate Actions While Background Sync is Active
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a visit to perform 
	  And I am within the POC visit allowed check in range
	  And I open the visit 
	  When I click on check in 
	  And The background sync is displayed 
	  Then I should be able to check out without being blocked by background sync 


	 Examples:
		|profile|
		|BDR User| 