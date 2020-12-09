@76956 @Android @OnTap @ignore @regression
Feature: POC insights Pop-Up Screen
	As a BDR
	I want to have a POC insights Icon in the Account 360 page
	So that I can click to check the POC performance, Pricing and Distribution insights and negotiate with the POC owner


	Scenario Outline: POC insights Pop-Up Screen
	  Given I am logged in OnTap as a "<profile>" 
	  And I am on the OnTap main page 
	  When I Open the POC Insights icon at the slider bar inside a visit 
	  Then will be Pop-Up a POC Insights Screen 


	 Examples:
		|profile|
		|BDR User| 