package com.ds.projecthelper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.Constants;
import com.ds.projecthelper.R;

public class InitialSetupSecondActivity extends AppCompatActivity implements Constants {
    private Button buttonNext;
    private TextView passwordField, loginField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_setup_second);

        loginField = findViewById(R.id.loginOrEmailTextField);
        passwordField = findViewById(R.id.passwordField);
        buttonNext = findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(v -> {
            if(checkForEnteredData()) startActivity(new Intent(this, InitialSetupThirdActivity.class)); else findErrorReason();
        });
    }

    private void findErrorReason() {
        checkField(loginField, "логина", MIN_LOGIN_LENGTH);
        checkField(passwordField, "пароля", MIN_PASSWORD_LENGTH);
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

    private void checkField(TextView textView, String title, int minLength){
        String textViewString = textView.getText().toString().trim();

        if(!textViewString.isEmpty()) {
            if (textViewString.length() < minLength)
                textView.setError("Длина " + title + " должна быть не менее " + minLength + " символов");
        }else textView.setError("Заполните поле");
    }
}
