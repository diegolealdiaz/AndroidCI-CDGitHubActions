package com.cdp.androidcicdgithubactions.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.cdp.androidcicdgithubactions.R;
import com.cdp.androidcicdgithubactions.databinding.ActivityMainBinding;
import com.cdp.androidcicdgithubactions.login.LoginActivity;
import com.cdp.androidcicdgithubactions.utils.Utils;

public class MainActivity extends AppCompatActivity implements MainActivityNavigator {
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;
    private String[] operaciones = {"Sumar","Restar","Multiplicar","Dividir"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.setNavigator(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,operaciones);
        binding.spiOperation.setAdapter(adapter);
        binding.btnOperation.setOnClickListener(View -> {
            Utils.getUtils().closeKeyboardMovil(MainActivity.this);
            getDataOperation();
        });


    }

    public void getDataOperation(){
        String number1 = binding.edtNumero1.getText().toString();
        String number2 = binding.edtNumero2.getText().toString();
        String operation = binding.spiOperation.getSelectedItem().toString();
        if (viewModel.validateData(number1,number2,operation)){
            viewModel.operationData(Integer.parseInt(number1),Integer.parseInt(number2),operation);
        }

    }

    @Override
    public void onDataError(String message, String option){
        Utils.getUtils().snackbarMessage(message,option,binding.main,getLayoutInflater(), MainActivity.this);;
    }

    @Override
    public void printResultView(int data){
        binding.result.setText("Resultado: " + data);
    }
}