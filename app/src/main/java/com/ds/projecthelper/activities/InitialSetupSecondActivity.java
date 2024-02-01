package com.ds.projecthelper.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.CheckTextViews;
import com.ds.projecthelper.Constants;
import com.ds.projecthelper.R;
import com.ds.projecthelper.util.AnotherActivity;

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

        buttonNext.setOnClickListener(v -> onNextButtonAction());
        iHaveAccount.setOnClickListener(v -> onHaveAccountButtonAction());
        iForgotMyPassword.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this, RestorePasswordActivity.class, false));
    }

    private void onNextButtonAction(){
        if(checkForEnteredData()) {
            AnotherActivity.gotoAnotherActivity(this, InitialSetupThirdActivity.class, true);
        } else findErrorReason();
    }

    private void onHaveAccountButtonAction(){
        iHaveAccount.setText(!logInIsOpen ? getResources().getString(R.string.i_have_not_account): getResources().getString(R.string.i_have_account));
        iForgotMyPassword.setVisibility(!logInIsOpen ? View.VISIBLE: View.INVISIBLE);
        title.setText(!logInIsOpen ? getResources().getString(R.string.well_lets_log_in): getResources().getString(R.string.first_let_s_create_account));
        logInIsOpen = !logInIsOpen;
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

}
