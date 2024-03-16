package com.ds.projecthelper.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.ds.projecthelper.R;
import com.ds.projecthelper.ShowAlerts;
import com.ds.projecthelper.user.UserController;
import com.ds.projecthelper.util.AnotherActivity;

public class InitialSetupFirstActivity extends AppCompatActivity {
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_initial_setup_first);

            buttonNext = findViewById(R.id.buttonNext);

            buttonNext.setOnClickListener(v -> AnotherActivity.gotoAnotherActivity(this, InitialSetupSecondActivity.class, true));
        }catch (Exception e){
            ShowAlerts.showDialog(this, e, true);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        checkAuthorization();
    }

    private void checkAuthorization(){
        if(UserController.isSignedIn()) AnotherActivity.gotoAnotherActivity(this, MainPage.class, true);
    }

}