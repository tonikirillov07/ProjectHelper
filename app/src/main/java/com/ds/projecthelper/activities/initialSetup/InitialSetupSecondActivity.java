package com.ds.projecthelper.activities.initialSetup;

import static com.ds.projecthelper.Constants.MIN_LOGIN_LENGTH;
import static com.ds.projecthelper.Constants.MIN_PASSWORD_LENGTH;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.CheckTextViews;
import com.ds.projecthelper.R;
import com.ds.projecthelper.dialogs.ErrorDialog;
import com.ds.projecthelper.activities.services.RestorePasswordActivity;
import com.ds.projecthelper.activities.settings.MainPage;
import com.ds.projecthelper.user.UserController;
import com.ds.projecthelper.util.AnotherActivity;
import com.ds.projecthelper.util.Utils;

public class InitialSetupSecondActivity extends AppCompatActivity {
    private Button buttonNext;
    private EditText passwordField, loginField;
    private TextView title, iHaveAccount, iForgotMyPassword;
    private boolean logInIsOpen = false;
    private CheckTextViews checkField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
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
        }catch (Exception e){
            ErrorDialog.showDialog(this, e, true);
        }
    }

    private void onNextButtonAction(){
        try {
            buttonNext.setEnabled(false);

            if (checkForEnteredData()) {
                if(!logInIsOpen)
                    UserController.createUser(getLoginText(), getPasswordText(), () -> AnotherActivity.gotoAnotherActivity(this, InitialSetupThirdActivity.class, true), this);
                else
                    UserController.logIn(getLoginText(), getPasswordText(), () -> AnotherActivity.gotoAnotherActivity(this, MainPage.class, true), this);
            } else findErrorReason();

            buttonNext.setEnabled(true);
        }catch (Exception e){
            ErrorDialog.showDialog(this, e, true);
        }
    }

    private void onHaveAccountButtonAction(){
        try {
            iHaveAccount.setText(!logInIsOpen ? getResources().getString(R.string.i_have_not_account) : getResources().getString(R.string.i_have_account));
            iForgotMyPassword.setVisibility(!logInIsOpen ? View.VISIBLE : View.INVISIBLE);
            title.setText(!logInIsOpen ? getResources().getString(R.string.well_lets_log_in) : getResources().getString(R.string.first_let_s_create_account));
            logInIsOpen = !logInIsOpen;

            Utils.clearEditText(loginField);
            Utils.clearEditText(passwordField);
        }catch (Exception e){
            ErrorDialog.showDialog(this, e, true);
        }
    }

    private void findErrorReason() {
        try {
            checkField.checkField(loginField, "login", MIN_LOGIN_LENGTH);
            checkField.checkField(passwordField, "password", MIN_PASSWORD_LENGTH);
        }catch (Exception e){
            ErrorDialog.showDialog(this, e, true);
        }
    }

    private boolean checkForEnteredData(){
        String loginEnteredData = getLoginText();
        String passwordEnteredData = getPasswordText();

        return (!loginEnteredData.isEmpty() & !passwordEnteredData.isEmpty()) & (loginEnteredData.length() >= 4 & passwordEnteredData.length() >= 8);
    }

    @NonNull
    private String getLoginText(){
        return loginField.getText().toString().trim();
    }

    @NonNull
    private String getPasswordText(){
        return passwordField.getText().toString().trim();
    }

}
