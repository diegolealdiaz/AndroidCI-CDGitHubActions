package com.cdp.androidcicdgithubactions.login;

import android.util.Patterns;

import androidx.core.util.PatternsCompat;
import androidx.lifecycle.ViewModel;

import com.cdp.androidcicdgithubactions.utils.Utils;

import java.util.regex.Pattern;

public class LoginActivityViewModel extends ViewModel {
    private LoginActivityNavigator navigator;

    public void setNavigator(LoginActivityNavigator navigator){
        this.navigator = navigator;
    }

    public boolean validateDataInput(String username, String password){
        if (username.isEmpty() || password.isEmpty()) {
            if (navigator != null)
                navigator.onLoginError("El nombre de usuario o la contraseña no pueden estar vacíos","error");
            return false;
        }
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        System.out.println(pattern);
        if (!PatternsCompat.EMAIL_ADDRESS.matcher(username).matches()){
            if (navigator != null)
                navigator.onLoginError("Email invalido","usererror");
            return false;
        }

        if (password.length() < 6){
            if (navigator != null)
                navigator.onLoginError("La contraseña debe ser superior a 5 digitos","passworderror");
            return false;
        }
        return true;
    }

    public void validateUser(String username, String password){
        if (username.equals("d@gmail.com") && password.equals("123456")){
            navigator.onSuccessUser();
        }
        else
        {
            navigator.onLoginError("Usuario o Contraseña incorrecta!!!","error");
        }
    }
}
