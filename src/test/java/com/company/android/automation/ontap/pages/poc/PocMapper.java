package com.company.android.automation.ontap.pages.poc;

import org.openqa.selenium.By;

public class PocMapper {
	public static final By POC_SEARCH_BAR = By.id("searchEditText");

	public static By accountName(String name) {
		return By.xpath("(//android.widget.TextView[@text='" + name + "'])[1]");
	}
}
