package com.company.android.automation.ontap.steps;

import io.cucumber.java.en.Then;
import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.account360.Account360Page;
import com.company.android.automation.ontap.steps.shared.Hook;

//TODO
public class Feature96688 {
	private Account360Page account360Page =  FactoryPage.factory(Account360Page.class, Hook.appium);
public Feature96688(){}
@Then("will be available a search bar on the top of the screen")
public void willBeAvailableASearchBarOnTheTopOfTheScreen(){
		Assert.assertTrue(account360Page.validateFieldPosition());
}

}
