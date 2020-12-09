package com.company.android.automation.ontap.exceptions;

public class ElementDisplayedException extends Exception {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  public ElementDisplayedException(String message) {
    super("Element displayed: " + message);
  }
}
