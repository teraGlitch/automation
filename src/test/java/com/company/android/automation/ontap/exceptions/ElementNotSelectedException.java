package com.company.android.automation.ontap.exceptions;

public class ElementNotSelectedException extends Exception {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  public ElementNotSelectedException(String message) {
    super("Element not selected: " + message);
  }
}
