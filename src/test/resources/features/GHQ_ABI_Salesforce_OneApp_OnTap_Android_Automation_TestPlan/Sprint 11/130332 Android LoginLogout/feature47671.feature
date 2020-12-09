@47671 @Android @OnTap @regression
Feature: First login of the day on Android device
	As an OnTap user
	I wantto have a 'loading' progress bar
	SoI can understand how much longer or what is the progress of my sync process
	
	Mockup:
	https://xd.adobe.com/view/092678c0-0419-4d11-5ba5-2f7cad9b99b8-7f17/screen/210e24b7-7d54-423c-9113-b6df16d1932d/Home-1


	Scenario Outline: First login of the day on Android device
	  Given I have opened the OnTap app 
	  And The Salesforce authentication page is displayed
		And I enter the credentials for "<profile>"
	  When I click on login button 
	  And The system starts syncing 
	  Then A progress bar in percent should be displayed 


	 Examples:
		|profile|
		|BDR User| 