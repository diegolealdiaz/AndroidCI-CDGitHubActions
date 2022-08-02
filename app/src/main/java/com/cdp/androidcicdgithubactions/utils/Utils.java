package com.cdp.androidcicdgithubactions.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.cdp.androidcicdgithubactions.R;
import com.google.android.material.snackbar.Snackbar;

public class Utils {
    private static Utils utils;

    public static Utils getUtils(){
        if(utils == null){
            utils = new Utils();
        }
        return utils;
    }

    public void snackbarMessage(String message, String option, ConstraintLayout layout, LayoutInflater inflater, Activity context) {
        closeKeyboardMovil(context);
        final Snackbar snackbar = Snackbar.make(layout,"",Snackbar.LENGTH_LONG);
        View custom;
        if (option.equals("error")){

            custom = inflater.inflate(R.layout.snackbar_error, null);
        }
        else
        {
            custom = inflater.inflate(R.layout.snackbar_success, null);
        }
        snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        snackbarLayout.setPadding(0,0,0,0);
        TextView messageErrorSnackBar = custom.findViewById(R.id.message_error);
        messageErrorSnackBar.setText(message);
        (custom.findViewById(R.id.ok_error)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbarLayout.addView(custom,0);
        snackbar.show();
    }

    public void closeKeyboardMovil(Activity context){
        View view = context.getCurrentFocus();
        if (view != null){
            InputMethodManager input = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            input.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}
