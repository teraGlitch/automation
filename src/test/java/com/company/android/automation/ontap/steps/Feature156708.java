package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.annotations.Automated;
import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.login.LoginPage;
import com.company.android.automation.ontap.pages.visit_list.VisitListPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.*; 

@Automated
public class Feature156708 {
	
private VisitListPage visitListPage;
private LoginPage loginPage;

public Feature156708(){
	visitListPage = FactoryPage.factory(VisitListPage.class, Hook.appium);
	loginPage= FactoryPage.factory(LoginPage.class, Hook.appium);
}
@When("I remove a {string} on app settings")
public void iRemoveAPermissionOnAppSettings(String permission){
		visitListPage.grantOrRevokeAPermission(permission, false);
}

@And("I back to the app")
public void iBackToTheApp(){
		visitListPage.returnToTheApp();
}

@Then("The app displays me a pop up for allow the {string}")
public void theAppDisplaysMeAPopUpForAllowThePermission(String permission){
  Assert.assertTrue(loginPage.clickOnPermissionDynamically(permission));
}

@And("I can accept the denied permission again")
public void iCanAcceptTheDeniedPermissionAgain(){
	Assert.assertTrue(loginPage.validateIfPermissionEnable(),"#Access permissions have not  been Validate");
}

}
