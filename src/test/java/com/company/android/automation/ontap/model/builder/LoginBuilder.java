package com.company.android.automation.ontap.model.builder;

import com.company.android.automation.ontap.model.LoginModel;

public final class LoginBuilder {

    private final LoginModel login;

    public LoginBuilder() {
        login = new LoginModel();
    }

    public static LoginBuilder builder() {
        return new LoginBuilder();
    }

    public LoginBuilder withUserName(String userName) {
        this.login.setUserName(userName);

        return this;
    }

    public LoginBuilder withPassword(String password) {
        this.login.setPassword(password);

        return this;
    }

    public LoginBuilder withProfile(String profile) {
        this.login.setProfile(profile);

        return this;
    }

    public LoginBuilder withNameUser(String name) {
        this.login.setNameUser(name);

        return this;
    }


    public LoginModel build() {
        return this.login;
    }


}
