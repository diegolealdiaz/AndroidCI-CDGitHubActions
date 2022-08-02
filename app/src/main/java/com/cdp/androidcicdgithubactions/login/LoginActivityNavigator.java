package com.cdp.androidcicdgithubactions.login;

public interface LoginActivityNavigator {
    void onLoginError(String message, String option);
    void onSuccessUser();
}
