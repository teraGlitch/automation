@96688 @Android @iOS @OnTap @ignore @regression
Feature: Search Bar on the Orders Page
	As a BDR
	I want a Search Option in the Order List Page
	So that I can look for any specific field available in my phone and find the order I am looking for


	Scenario Outline: Search Bar on the Orders Page
	  Given I am logged in OnTap as a "<profile>"
	  And I am on the OnTap main page
	  When accessing Orders at the User 360 Page 
	  Then will be available a search bar on the top of the screen 


	 Examples:
		|profile|
		|BDR User| 