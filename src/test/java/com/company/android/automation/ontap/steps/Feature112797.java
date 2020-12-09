package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.annotations.Automated;
import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.login.LoginPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

@Automated
public class Feature112797 {
private LoginPage loginPage;

public Feature112797(){
  loginPage = FactoryPage.factory(LoginPage.class, Hook.appium);
}

@And("I turn off the celular data")
public void iTurnOffTheCelularData(){
		loginPage.toggleDeviceConnection(false);
}

@And("I get an error message during the first sync")
public void iGetAnErrorMessageDuringTheFirstSync(){
  String errorMessage = loginPage.getModalContextText();
  Assert.assertTrue(errorMessage.contains("Please check the internet connection") ||
                    errorMessage.contains("problem to sync data with Salesforce"));
}

@And("I turn on the celular data")
public void iTurnOnTheCelularData(){
  loginPage.toggleDeviceConnection(true);
}

@When("I will click on the logout option in the message")
public void iWillClickOnTheLogoutOptionInTheMessage(){
  loginPage.clickModalButton("LOG OUT");
}

@Then("I will be redirected to Salesforce login page")
public void iWillBeRedirectedToSalesforceLoginPage(){
  Assert.assertTrue(loginPage.checkSalesforceLoginPage(), "Salesforce authentication page was not displayed");
}

}
