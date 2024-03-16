package com.ds.projecthelper.activities;

import static com.ds.projecthelper.Constants.MIN_EMAIL_LENGTH;
import static com.ds.projecthelper.Constants.MIN_PERSONAL_CODE_LENGTH;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.CheckTextViews;
import com.ds.projecthelper.R;
import com.ds.projecthelper.ShowAlerts;

public class RestorePasswordActivity extends AppCompatActivity {
    private EditText mailTextField, personalCodeTextField;
    private Button buttonNextWithEmail, buttonNextWithPersonalCode;
    private CheckTextViews checkTextViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.password_restore_page);

            checkTextViews = new CheckTextViews();

            mailTextField = findViewById(R.id.emailAddressTextField);
            personalCodeTextField = findViewById(R.id.personalCodeTextField);
            buttonNextWithEmail = findViewById(R.id.buttonNextWithEmail);
            buttonNextWithPersonalCode = findViewById(R.id.buttonNextWithPersonalCode);

            buttonNextWithEmail.setOnClickListener(v -> onRestoreWithEmailButtonClick());
            buttonNextWithPersonalCode.setOnClickListener(v -> onRestoreWithPersonalCodeButtonClick());
        }catch (Exception e){
            ShowAlerts.showDialog(this, e, true);
        }
    }

    @NonNull
    private String getEmail(){
        return mailTextField.getText().toString().trim();
    }

    @NonNull
    private String getPersonalCode(){
        return personalCodeTextField.getText().toString().trim();
    }

    private void onRestoreWithEmailButtonClick(){
        if(checkTextViews.checkField(mailTextField, MIN_EMAIL_LENGTH)) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }else checkTextViews.checkField(mailTextField, "email", MIN_EMAIL_LENGTH);
    }

    private void onRestoreWithPersonalCodeButtonClick(){
        if(checkTextViews.checkField(personalCodeTextField, MIN_PERSONAL_CODE_LENGTH)) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }else checkTextViews.checkField(personalCodeTextField, "personal code", MIN_EMAIL_LENGTH);
    }
}
