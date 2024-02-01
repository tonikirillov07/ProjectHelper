package com.ds.projecthelper.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.CheckTextViews;
import com.ds.projecthelper.Constants;
import com.ds.projecthelper.R;

public class RestorePasswordActivity extends AppCompatActivity implements Constants {
    private EditText mailTextField, personalCodeTextField;
    private Button buttonNextWithEmail, buttonNextWithPersonalCode;
    private CheckTextViews checkTextViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_restore_page);

        checkTextViews = new CheckTextViews();

        mailTextField = findViewById(R.id.emailAddressTextField);
        personalCodeTextField = findViewById(R.id.personalCodeTextField);
        buttonNextWithEmail = findViewById(R.id.buttonNextWithEmail);
        buttonNextWithPersonalCode = findViewById(R.id.buttonNextWithPersonalCode);

        buttonNextWithEmail.setOnClickListener(v -> {
            if(!getEmail().isEmpty() & getEmail().length() >= MIN_EMAIL_LENGTH) {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }else checkTextViews.checkField(mailTextField, "email", MIN_EMAIL_LENGTH);
        });

        buttonNextWithPersonalCode.setOnClickListener(v -> {
            if(!getPersonalCode().isEmpty() & getPersonalCode().length() >= MIN_PERSONAL_CODE_LENGTH) {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }else checkTextViews.checkField(personalCodeTextField, "personal code", MIN_EMAIL_LENGTH);
        });
    }

    private String getEmail(){
        return mailTextField.getText().toString().trim();
    }

    private String getPersonalCode(){
        return personalCodeTextField.getText().toString().trim();
    }
}
