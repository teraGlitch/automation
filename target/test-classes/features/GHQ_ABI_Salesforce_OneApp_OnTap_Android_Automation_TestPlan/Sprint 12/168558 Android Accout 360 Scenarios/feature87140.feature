@87140 @Android @Global @OnTap @ignore @regression
Feature: User Execution KPIs - Child KPI Information
	As a BDR
	I want to see Child KPI's inside Coverage and Execution categories
	So that I can deep dive in the KPI information to check what I am missing


	Scenario Outline: User Execution KPIs - Child KPI Information
	  Given I am logged in OnTap as a "<profile>" 
	  And I go to the User KPIs Page 
	  When I open the KPI "<Execution_KPI>" 
	  Then I will be taken to the Child KPI Page 
	  And the KPI will be displayed as a Result Chart "<Execution_KPI_chart>" 


	 Examples:
		|Execution_KPI_chart|Execution_KPI|profile|
		|Progress bar|POCE|BDR User|
		|Traffic Ligth|Zero Sales|BDR User|
		|Progress bar|Giro Minimo|BDR User| 