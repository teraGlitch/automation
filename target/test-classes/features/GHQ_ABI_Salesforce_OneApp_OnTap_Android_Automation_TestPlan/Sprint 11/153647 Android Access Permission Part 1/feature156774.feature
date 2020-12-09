@156774 @Automation @OnTap @regression
Feature: Validate Displayed Message After Turning Off Location and Turn On Again
	As anAutomation Developer
	I want to automate the Access Permission on OnTap app
	So thatthe BDR will be able to access the OnTap system


	Scenario Outline: Validate Displayed Message After Turning Off Location and Turn On Again
	  Given I am logged in OnTap as a "<profile>" 
	  When I turn off the device GPS 
	  And I back to the app 
	  Then A message about the disabled location is displayed by the app
	  And I can turn on location again 


	 Examples:
		|profile|
		|BDR User| 