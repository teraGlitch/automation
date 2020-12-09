package com.company.android.automation.ontap.exceptions;

public class ActionNotCompletedException extends RuntimeException {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  public ActionNotCompletedException(String message) {
    super("Action not completed: " + message);
  }
}
