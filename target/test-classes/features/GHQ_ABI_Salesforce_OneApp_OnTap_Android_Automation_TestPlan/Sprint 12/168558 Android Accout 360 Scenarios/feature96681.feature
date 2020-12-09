@96681 @Android @iOS @OnTap @ignore @regression
Feature: See All Orders Option on the Account 360 Page
	As anAutomation Developer
	I wantTo automate the Account 360 scenariosSo thatThe BDR will be able to use the OnTap system
	


	Scenario Outline: See All Orders Option on the Account 360 Page
	  Given I am logged in OnTap as a "<profile>" 
	  When accessing Orders at the User 360 Page 
	  Then the orders list will be displayed 


	 Examples:
		|profile|
		|BDR User| 