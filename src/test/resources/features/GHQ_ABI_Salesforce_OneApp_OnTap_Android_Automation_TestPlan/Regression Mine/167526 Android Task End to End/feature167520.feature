@167520 @Android @Automation @OnTap @ignore @regression
Feature: Validate an E2E Test for Planned Visit with POC - Other - Poster Type Task
	
	As anAutomation DeveloperI wantTo automate the taskpath end to end
	So thatThe BDR will be able to use OnTap system


	Scenario Outline: Validate an E2E Test for Planned Visit with POC - Other - Poster Type Task
	  Given I am logged in OnTap as a "<profile>" 
	  And I have a "<visit>" visit to perform 
	  And I have a "<recordType>" "<type>" "<subtype>" task to perform during the visit 
	  And I did the check in successfully in the visit 
	  When I open the task created before 
	  Then I should be able to complete the POC task type Other and subtype Poster 
	  And I am able to check out 


	 Examples:
		|subtype|recordType|profile|visit|type|
		|Poster|POC|BDR QA Test|Planned Visit|Other| 