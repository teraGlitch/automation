package com.company.android.automation.ontap.model.builder;

import com.company.android.automation.ontap.model.Account;

public class AccountBuilder {
  private Account account;
  
  public AccountBuilder() {
    account = new Account();
  }
  
  public AccountBuilder id(String id) {
    account.setId(id);
    return this;
  }
  
  public AccountBuilder name(String name) {
    account.setName(name);
    return this;
  }
  
  public Account build() {
    return account;
  }
}
