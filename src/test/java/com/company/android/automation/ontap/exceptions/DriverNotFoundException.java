package com.company.android.automation.ontap.exceptions;

public class DriverNotFoundException extends RuntimeException {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public DriverNotFoundException() {
    super("No driver found!");
  }
}
