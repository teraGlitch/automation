package com.company.android.automation.ontap.steps;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.company.android.automation.ontap.annotations.Automated;
import com.company.android.automation.ontap.model.LoginModel;
import com.company.android.automation.ontap.model.bulkdata.LoginBulkData;
import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.login.LoginPage;
import com.company.android.automation.ontap.pages.visit_list.VisitListPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

@Automated
public class Feature156694 {
	private LoginPage loginPage;
	private VisitListPage visitListPage;

	public Feature156694(){
		loginPage = FactoryPage.factory(LoginPage.class, Hook.appium);
		visitListPage = FactoryPage.factory(VisitListPage.class, Hook.appium);
	}

	@Given("I have logged on OnTap App with the {string} for the first time")
	public void iHaveLoggedOnOnTapAppWithTheProfileForTheFirstTime(String profile) throws InterruptedException{
		LoginModel login = LoginBulkData.getLogin(profile);
		loginPage
		.changeServerToSandbox()
		.fillSalesforceCredencials(login.getUserName(), login.getPassword())
		.clickSalesforceLoginButton()
		.allowSalesforcePermitions();
	}

	@And("The first sync is finished")
	public void theFirstSyncIsFinished(){
		loginPage.waitInvisibilitySync();
	}

	@When("I allow all the permissions excluding {string}")
	public void iAllowAllThePermissionsExcludingPermission(String whichPermission){
		visitListPage.allowOrDenyPermissions(whichPermission);
	}

	@Then("The message about permission required is displayed")
	public void theMessageAboutPermissionRequiredIsDisplayed(){
		assertTrue(visitListPage.validateModalTextView("permissions in order to work properly"), "Permission message not displayed");
		visitListPage.clickModalButton("OK");
	}

	@And("I cannot access the app until the {string} is allowed")
	public void iCannotAccessTheAppUntilAllthePermissionsisAllowed(String whichPermission) throws Exception{
		visitListPage.allowDeniedPermission(whichPermission);
		visitListPage.clickOnHamburger();
		assertNotNull(visitListPage.validateLogo(), "couldn't access the app");
	}

}
