package com.cdp.androidcicdgithubactions.menu;

public interface MainActivityNavigator {
    void onDataError(String message, String option);
    void printResultView(int data);
}
