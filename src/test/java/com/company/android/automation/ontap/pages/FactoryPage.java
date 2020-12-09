package com.company.android.automation.ontap.pages;

import java.lang.reflect.Constructor;

import com.company.android.automation.ontap.driver.AppiumMobileDriver;

@SuppressWarnings("unchecked")
public class FactoryPage {

    public static <T extends Page> T factory(Class<T> clazz, AppiumMobileDriver driver) {
        try {
            Constructor<? extends Page> constructorObject = clazz.getDeclaredConstructor(AppiumMobileDriver.class);
            constructorObject.setAccessible(true);
            return (T) constructorObject.newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
