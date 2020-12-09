package com.company.android.automation.ontap.steps;

import org.testng.Assert;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.account360.Account360Page;
import com.company.android.automation.ontap.pages.checkin_checkout.CheckIn_CheckOutPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

//TODO
public class Feature76956 {
  private CheckIn_CheckOutPage checkIn_CheckOutPage;
  private Account360Page account360Page;
  
public Feature76956(){
  checkIn_CheckOutPage = FactoryPage.factory(CheckIn_CheckOutPage.class, Hook.appium);
  account360Page = FactoryPage.factory(Account360Page.class, Hook.appium);
}
@When("I Open the POC Insights icon at the slider bar inside a visit")
public void iOpenThePOCInsightsIconAtTheSliderBarInsideAVisit(){
  // TODO - Bulk data creates a visit, based on available POCs in Salesforce database
  String pocName = "A BEBER RECORTANDO"; // TODO - Receives created visit POC name
  checkIn_CheckOutPage.clickOnAccountName(pocName);
  account360Page.clickOnPocInsightsButton();
}

@Then("will be Pop-Up a POC Insights Screen")
public void willBePopUpAPOCInsightsScreen(){
  Assert.assertTrue(account360Page.checkPOCInsightsPopUpAppeared(), "The POC Insights pop-up did not appear.");
}

}
