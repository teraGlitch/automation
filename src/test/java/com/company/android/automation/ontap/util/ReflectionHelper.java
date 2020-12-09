package com.company.android.automation.ontap.util;

import java.util.Set;

import org.reflections.Reflections;

import com.company.android.automation.ontap.annotations.Automated;
import com.company.android.automation.ontap.steps.shared.ConfigurationTest;


public class ReflectionHelper {

    public static Set<Class<?>> getAllClassAutomated(){
        Reflections reflections = new Reflections(ConfigurationTest.PACKAGE_STEPS);
        return reflections.getTypesAnnotatedWith(Automated.class);
    }
}
