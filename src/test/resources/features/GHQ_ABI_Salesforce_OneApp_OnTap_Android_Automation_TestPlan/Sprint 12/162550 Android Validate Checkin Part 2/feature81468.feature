@81468 @Android @iOS @OnTap @ignore @regression
Feature: Background Sync Being Displayed When Entering in a Visit
	As a BDR
	I want to sync data for a POC that I have included in my visit list as a Non-Planned Visit
	So that if I have an unplanned visit, I will have the information for this customer available at my phone


	Scenario Outline: Background Sync Being Displayed When Entering in a Visit
	  Given I am logged in OnTap as a "<profile>" 
	  And I am on the OnTap main page
	  And I have a visit to perform 
	  When I open the created visit 
	  Then I should see the background sync at the top of the screen 


	 Examples:
		|profile|
		|BDR User| 