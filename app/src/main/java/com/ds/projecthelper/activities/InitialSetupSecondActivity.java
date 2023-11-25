package com.ds.projecthelper.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.CheckTextViews;
import com.ds.projecthelper.Constants;
import com.ds.projecthelper.R;

public class InitialSetupSecondActivity extends AppCompatActivity implements Constants {
    private Button buttonNext;
    private EditText passwordField, loginField;
    private TextView title, iHaveAccount, iForgotMyPassword;
    private boolean logInIsOpen = false;
    private CheckTextViews checkField;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_setup_second);

        loginField = findViewById(R.id.loginOrEmailTextField);
        passwordField = findViewById(R.id.passwordField);
        buttonNext = findViewById(R.id.buttonNext);
        title = findViewById(R.id.title);
        iHaveAccount = findViewById(R.id.iHaveAccount);
        iForgotMyPassword = findViewById(R.id.iForgotPassword);

        checkField = new CheckTextViews();

        buttonNext.setOnClickListener(v -> {
            if(checkForEnteredData()) startActivity(new Intent(this, InitialSetupThirdActivity.class)); else findErrorReason();
        });

        iHaveAccount.setOnClickListener(v -> {
            if(!logInIsOpen){
                iHaveAccount.setText("I haven't account");
                iForgotMyPassword.setVisibility(View.VISIBLE);
                title.setText("Well, then let’s log in");

                logInIsOpen = true;
            }else{
                iHaveAccount.setText("I have account");
                iForgotMyPassword.setVisibility(View.INVISIBLE);
                title.setText("First, let’s create account");

                logInIsOpen = false;
            }
        });

        iForgotMyPassword.setOnClickListener(v -> {
            startActivity(new Intent(this, RestorePasswordActivity.class));
        });
    }

    private void findErrorReason() {
        checkField.checkField(loginField, "login", MIN_LOGIN_LENGTH);
        checkField.checkField(passwordField, "password", MIN_PASSWORD_LENGTH);
    }

    private boolean checkForEnteredData(){
        String loginEnteredData = getLoginText();
        String passwordEnteredData = getPasswordText();

        return (!loginEnteredData.isEmpty() & !passwordEnteredData.isEmpty()) & (loginEnteredData.length() >= 4 & passwordEnteredData.length() >= 8);
    }

    private String getLoginText(){
        return loginField.getText().toString().trim();
    }

    private String getPasswordText(){
        return passwordField.getText().toString().trim();
    }

    private void makeLogInView(){

    }
}
