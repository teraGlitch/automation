@167494 @Android @Automation @OnTap @ignore @regression
Feature: Validate an E2E Test for Unplanned Visit with Basic Survey
	As an Automation DeveloperI want To automate the survey path end to end
	So that The BDR will be able to use OnTap system


	Scenario Outline: Validate an E2E Test for Unplanned Visit with Basic Survey
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a already completed visit 
	  And I have a "<type>" survey to perform during the visit 
	  And I did the check in successfully in the visit 
	  When I open the survey created before 
	  Then I should be able to complete my basic survey 
	  And I am able to check out 


	 Examples:
		|profile|type|
		|BDR User|Basic| 