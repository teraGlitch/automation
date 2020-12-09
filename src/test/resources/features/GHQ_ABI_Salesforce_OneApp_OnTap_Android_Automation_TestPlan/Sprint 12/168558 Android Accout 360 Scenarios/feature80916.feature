@80916 @Android @iOS @OnTap @ignore @regression
Feature: POC Potential Revenue Value is <> 0  (What can we do phrase)
	As a BDR
	I want to have a POC Insights Screen
	So that I can check


	Scenario Outline: POC Potential Revenue Value is <> 0  (What can we do phrase)
	  Given I am logged in OnTap as a "<profile>" 
	  And I am on the OnTap main page 
	  And I am at POCs Page 
	  When I open the POC Insights inside the POC 
	  And I have a POC where the Potential Revenue value is different than zero 
	  Then the What can we do phrase will displays the "<phrase>" 


	 Examples:
		|phrase|profile|
		|This means that you could be selling|BDR User| 