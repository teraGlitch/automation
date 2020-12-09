package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.annotations.Automated;
import com.company.android.automation.ontap.model.LoginModel;
import com.company.android.automation.ontap.model.bulkdata.LoginBulkData;
import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.login.LoginPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Automated
public class Feature47671 {
private LoginPage loginPage;

public Feature47671(){
  loginPage = FactoryPage.factory(LoginPage.class, Hook.appium);
}

@Given("I have opened the OnTap app")
public void iHaveOpenedTheOnTapApp() throws InterruptedException{
  loginPage.changeServerToSandbox();
  Assert.assertTrue(loginPage.checkSalesforceLoginPage(), "Salesforce authentication page was not displayed");
}

@And("The Salesforce authentication page is displayed")
public void theSalesforceAuthenticationPageIsDisplayed(){
  Assert.assertTrue(loginPage.checkSalesforceLoginPage(), "Salesforce authentication page was not displayed");
}

@And("I enter the credentials for {string}")
public void iEnterTheCredentialsForProfile(String profile){
  LoginModel login = LoginBulkData.getLogin(profile);
  loginPage.fillSalesforceCredencials(login.getUserName(), login.getPassword());
}

@When("I click on login button")
public void iClickOnLoginButton(){
  loginPage
          .clickSalesforceLoginButton()
          .allowSalesforcePermitions();
}

@And("The system starts syncing")
public void theSystemStartsSyncing(){
  Assert.assertTrue(loginPage.syncProgressBarIsDisplayed(), "Sync bar was not displayed");;
}

@Then("A progress bar in percent should be displayed")
public void aProgressBarInPercentShouldBeDisplayed(){
  Assert.assertNotNull(loginPage.getSyncProgressPercentage(), "Sync percentage was not displayed");
}

}
