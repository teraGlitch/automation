package com.company.android.automation.ontap.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/***
 * Indicates the scenario is implemented
 * @author Thiago Santos
 * @since 19-08-2019
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Automated {
}
