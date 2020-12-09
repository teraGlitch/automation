package com.company.android.automation.ontap.constants;

import java.io.File;

public class Paths {
  public static final String PROJECT_PATH = System.getProperty("user.dir");
  public static final String EVIDENCES_PATH = PROJECT_PATH + File.separator + "output" + File.separator;
  public static final String DICTIONARY_PATH = PROJECT_PATH + File.separator + "dictionary.yaml";
  public static final String PROPERTY_FILE_PATH = PROJECT_PATH + File.separator + "Properties" + File.separator + "config.properties";
  public static final String PROJECT_ROOT_PACKAGE = "com..company.android.automation";
}
