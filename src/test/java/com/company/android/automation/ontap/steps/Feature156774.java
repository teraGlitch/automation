package com.company.android.automation.ontap.steps;

import static org.testng.Assert.assertTrue;

import com.company.android.automation.ontap.annotations.Automated;
import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.visit_list.VisitListPage;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then; 

@Automated
public class Feature156774 {
private VisitListPage visitListPage;

public Feature156774(){
  visitListPage = FactoryPage.factory(VisitListPage.class, Hook.appium);
}

@Then("A message about the disabled location is displayed by the app")
public void aMessageAboutTheDisabledLocationIsDisplayedByTheApp(){
  assertTrue(visitListPage.validateModalTextView("Access to location is disabled."), "App location disabled alert not appears");
}
@And("I can turn on location again")
public void iCanTurnOnLocationAgain(){
  visitListPage.toggleDeviceLocation(true);
  visitListPage.clickModalButtonIfExists("CANCEL");
  visitListPage.returnToTheApp();
  assertTrue(!visitListPage.checkModalIsOpen() ||
      !visitListPage.getModalContextText().contains("Access to location is disabled."), 
      "App location disabled alert keep showing up");
}

}
