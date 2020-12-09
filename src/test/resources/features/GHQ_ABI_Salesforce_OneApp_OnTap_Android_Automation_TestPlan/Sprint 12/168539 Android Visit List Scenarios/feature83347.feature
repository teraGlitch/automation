@83347 @Android @iOS @OnTap @ignore @regression
Feature: Create an Unplanned Visit
	As a BDR
	I want to sync data for a POC that I have included in my visit list as a Non-Planned Visit
	So that if I have an unplanned visit, I will have the information for this customer available at my phone


	Scenario Outline: Create an Unplanned Visit
	  Given that I am at the POC Search Page 
	  When I have chosen an Account "<account>" in the list and click on the icon more to add 
	  Then a warning will be displayed with the message Unplanned visit created successfully
	  And the unplanned visit will be displayed on the visit list as Unplanned visit Event Type


	 Examples:
		|account|
		|COLMADO SANTA| 