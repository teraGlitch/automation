package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.annotations.Automated;
import com.company.android.automation.ontap.enums.AndroidPermission;
import com.company.android.automation.ontap.model.LoginModel;
import com.company.android.automation.ontap.model.bulkdata.LoginBulkData;
import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.login.LoginPage;
import com.company.android.automation.ontap.pages.visit_list.VisitListPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.*; 

@Automated
public class Feature49799 {
private LoginPage loginPage;
private VisitListPage visitListPage;

public Feature49799(){
  loginPage = FactoryPage.factory(LoginPage.class, Hook.appium);
  visitListPage = FactoryPage.factory(VisitListPage.class, Hook.appium);
}

@Given("I am logged in OnTap as a {string}")
public void iAmLoggedInOnTapAsAProfile(String profile) throws InterruptedException{
  LoginModel login = LoginBulkData.getLogin(profile);
  loginPage
      .changeServerToSandbox()
      .fillSalesforceCredencials(login.getUserName(), login.getPassword())
      .clickSalesforceLoginButton()
      .allowSalesforcePermitions();
}

@And("I am on the OnTap main page")
public void iAmOnTheOnTapMainPage(){
  loginPage.waitInvisibilitySync();
  loginPage
    .clickAndroidButtonPermission(AndroidPermission.CONTACTS, "ALLOW")
    .clickAndroidButtonPermission(AndroidPermission.FILES, "ALLOW")
    .clickAndroidButtonPermission(AndroidPermission.LOCATION, "ALLOW")
    .clickAndroidButtonPermission(AndroidPermission.PHONE, "ALLOW")
    .clickAndroidButtonPermission(AndroidPermission.CAMERA, "ALLOW");
  loginPage.clickModalButtonIfExists("OK");
  Assert.assertTrue(visitListPage.dateVisitListBarIsPresent(), "OnTap main page was not displayed");
}

@When("I click on the side menu button")
public void iClickOnTheSideMenuButton(){
  visitListPage.clickToOpenSideBarMenu();
}

@Then("The logout option should be displayed in the menu")
public void theLogoutOptionShouldBeDisplayedInTheMenu(){
  Assert.assertTrue(visitListPage.checkMenuButtonExists("Log out"), "Logout button was not present on menu side bar");
}

}
