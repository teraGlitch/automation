@59463 @Android @iOS @OnTap @ignore @regression
Feature: Last Order Info Card on the Account 360 Page
	As anAutomation Developer
	I wantTo automate the Account 360 scenariosSo thatThe BDR will be able to use the OnTap system
	


	Scenario Outline: Last Order Info Card on the Account 360 Page
	  Given I am logged in OnTap as a "<profile>" 
	  And I am at the Ordes page 
	  When I scroll down to the bottom of the page 
	  Then I can see a card with the last order info 


	 Examples:
		|profile|
		|BDR User| 