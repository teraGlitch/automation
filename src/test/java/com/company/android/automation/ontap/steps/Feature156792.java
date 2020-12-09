package com.company.android.automation.ontap.steps;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.company.android.automation.ontap.annotations.Automated;
import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.login.LoginPage;
import com.company.android.automation.ontap.pages.visit_list.VisitListPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

@Automated
public class Feature156792 {
	private VisitListPage visitListPage;
	private LoginPage loginPage;

	public Feature156792(){
		visitListPage = FactoryPage.factory(VisitListPage.class, Hook.appium);
		loginPage = FactoryPage.factory(LoginPage.class, Hook.appium);
	}

	@When("I turn off the device GPS")
	public void iTurnOffTheDeviceGPS(){
		loginPage.waitInvisibilitySync();
		visitListPage.allowOrDenyPermissions("ALLOW");
		visitListPage.toggleDeviceLocation(false);
	}

	@Then("A message about the disabled location is displayed")
	public void aMessageAboutTheDisabledLocationIsDisplayed(){
		assertTrue(visitListPage.validateModalTextView("Access to location is disabled."), "couldn't access the app");
	}

	@And("I should be able to keep the location disabled")
	public void iShouldBeAbleToKeepTheLocationDisabled(){
		visitListPage.clickModalButtonIfExists("CANCEL");
		visitListPage.clickOnHamburger();
		assertNotNull(visitListPage.validateLogo(), "couldn't access the app");
	}

}
