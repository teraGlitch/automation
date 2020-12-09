@81466 @Android @iOS @OnTap @ignore @regression
Feature: Sync Data for Unplanned Visit
	As a BDR
	I want to sync data for a POC that I have included in my visit list as a Non-Planned Visit
	So that if I have an unplanned visit, I will have the information for this customer available at my phone


	Scenario Outline: Sync Data for Unplanned Visit
	  Given I am logged in OnTap as a "<profile>" 
	  And I am on the OnTap main page 
	  When I create an unplanned visit 
	  Then the app will sync the data in the background 
	  And the unplanned visit will be available 


	 Examples:
		|profile|
		|BDR User| 