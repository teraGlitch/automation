package com.company.android.automation.ontap.steps;

import com.company.android.automation.ontap.pages.FactoryPage;
import com.company.android.automation.ontap.pages.account360.Account360Page;
import com.company.android.automation.ontap.steps.shared.Hook;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 
//TODO
public class Feature96681 {
private Account360Page account360Page =  FactoryPage.factory(Account360Page.class, Hook.appium);

public Feature96681(){}
@When("accessing Orders at the User 360 Page")
public void accessingOrdersAtTheUser360Page() throws Exception{
	account360Page.accessSubmenuUser_360("User 360");
	account360Page.clickByText_User360("Orders");
}

@Then("the orders list will be displayed")
public void theOrdersListWillBeDisplayed(){
		throw new PendingException();
}

}
