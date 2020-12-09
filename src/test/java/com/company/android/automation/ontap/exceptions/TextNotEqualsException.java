package com.company.android.automation.ontap.exceptions;

public class TextNotEqualsException extends Exception {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  public TextNotEqualsException(String message) {
    super("Text not equals: " + message);
  }
}
