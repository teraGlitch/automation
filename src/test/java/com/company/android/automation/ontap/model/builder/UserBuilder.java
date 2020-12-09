package com.company.android.automation.ontap.model.builder;

import com.company.android.automation.ontap.model.User;

public class UserBuilder {
  private User user;
  
  public UserBuilder() {
    user = new User();
  }
  
  public UserBuilder id(String id) {
    user.setId(id);
    return this;
  }
  
  public UserBuilder name(String name) {
    user.setName(name);
    return this;
  }
  
  public UserBuilder username(String username) {
    user.setUsername(username);
    return this;
  }
  
  public UserBuilder country(String country) {
    user.setCountry(country);
    return this;
  }
  
  public UserBuilder language(String language) {
    user.setLanguage(language);
    return this;
  }
  
  public User build() {
    return user;
  }
}
