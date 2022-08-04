package com.cdp.androidcicdgithubactions.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cdp.androidcicdgithubactions.R;
import com.cdp.androidcicdgithubactions.databinding.ActivityLoginBinding;
import com.cdp.androidcicdgithubactions.menu.MainActivity;
import com.cdp.androidcicdgithubactions.utils.Utils;

public class LoginActivity extends AppCompatActivity implements LoginActivityNavigator {
    private LoginActivityViewModel viewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewModel = new ViewModelProvider(this).get(LoginActivityViewModel.class);
        viewModel.setNavigator(this);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        System.out.println("Inicio de Login");

        binding.btnLogin.setOnClickListener(View -> {
            getTextUser();
        });

    }

    private void getTextUser(){
        String user = binding.edtUsername.getText().toString();
        String password = binding.edtPassword.getText().toString();
        if(viewModel.validateDataInput(user,password)){
            viewModel.validateUser(user,password);
        }
    }

    @Override
    public void onLoginError(String message, String option) {
        switch (option){
            case "error":
                Utils.getUtils().snackbarMessage(message,option,binding.login,getLayoutInflater(),LoginActivity.this);
                break;
            case "usererror":
                binding.edtUsername.setFocusable(true);
                binding.edtUsername.setError(message);

                break;
            case "passworderror":
                binding.edtPassword.setError(message);
                binding.edtUsername.setFocusable(false);
                binding.edtPassword.setFocusable(true);
                break;
            default:
                break;
        }
    }

    @Override
    public void onSuccessUser() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }
}