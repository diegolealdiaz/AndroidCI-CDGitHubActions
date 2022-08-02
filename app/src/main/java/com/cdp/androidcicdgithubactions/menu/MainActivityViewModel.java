package com.cdp.androidcicdgithubactions.menu;

import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MainActivityNavigator navigator;

    public void setNavigator(MainActivityNavigator navigator){
        this.navigator = navigator;
    }

    public boolean validateData(String num1, String num2, String op){
        if (num1.isEmpty() || num2.isEmpty() || op.isEmpty()){
            navigator.onDataError("Por favor ingrese todos los campos","error");
            return false;
        }
        return true;
    }

    public void operationData(int num1, int num2, String op){
        int result = 0;
        switch (op){
            case "Sumar":
                result = num1 + num2;
                break;
            case "Restar":
                result = num1 - num2;
                break;
            case "Multiplicar":
                result = num1 * num2;
                break;
            case "Dividir":
                result = num1 / num2;
                break;
        }
        navigator.printResultView(result);

    }
}
