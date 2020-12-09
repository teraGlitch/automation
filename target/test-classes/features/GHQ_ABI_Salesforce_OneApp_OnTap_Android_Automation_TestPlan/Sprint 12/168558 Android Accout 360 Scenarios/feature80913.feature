@80913 @Android @iOS @OnTap @ignore @regression
Feature: Negative POC Insights Performance Value and Color
	As a BDR
	I want to have a POC Insights Screen
	So that I can check

	Scenario Outline: Negative POC Insights Performance Value and Color
	  Given I am logged in OnTap as a "<profile>" 
	  And I am on the OnTap main page 
	  When I Open the POC Insights icon at the slider bar inside a visit 
	  And the KPI value is negative 
	  Then the Color will be Red 

	 Examples:
		|profile |
		|BDR User|