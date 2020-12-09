package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.annotations.Automated;
import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.login.LoginPage;
import com.company.android.automation.ontap.pages.visit_list.VisitListPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.*; 

@Automated
public class Feature57197 {
private VisitListPage visitListPage;
private LoginPage loginPage;

public Feature57197(){
  visitListPage = FactoryPage.factory(VisitListPage.class, Hook.appium);
  loginPage = FactoryPage.factory(LoginPage.class, Hook.appium);
}

@And("I open the side menu")
public void iOpenTheSideMenu(){
  visitListPage.clickToOpenSideBarMenu();
}

@When("I click on the logout option")
public void iClickOnTheLogoutOption(){
  visitListPage.clickOnMenuButton("Log out");
}

@And("I confirm the logout")
public void iConfirmTheLogout(){
  visitListPage.clickModalButton("OK");
}

@Then("I will be logged out successfully")
public void iWillBeLoggedOutSuccessfully(){
  Assert.assertTrue(loginPage.checkSalesforceLoginPage(), "Salesforce authentication page was not displayed");
}

}
