package com.ds.projecthelper.activities.settings;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.R;
import com.ds.projecthelper.dialogs.ErrorDialog;
import com.ds.projecthelper.util.Utils;

public class MainPage extends AppCompatActivity {
    private ImageButton mainSettingsButton, mainButton, messengerButton, ideasButton, roadmapButton;
    private LinearLayout buttonsBarLinearLayout, headerLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_page);

            mainSettingsButton = findViewById(R.id.mainSettingsButton);
            mainButton = findViewById(R.id.mainButton);
            messengerButton = findViewById(R.id.messengerButton);
            ideasButton = findViewById(R.id.ideasButton);
            roadmapButton = findViewById(R.id.roadmapButton);
            buttonsBarLinearLayout = findViewById(R.id.buttonsBarLinearLayout);
            headerLinearLayout = findViewById(R.id.headerLinearLayout);

            mainSettingsButton.setOnClickListener(v -> onSettingsButtonAction());
        }catch (Exception e){
            ErrorDialog.showDialog(this, e, true);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Utils.addTranslateAnimationByUpOrByDown(headerLinearLayout, true);
        Utils.addTranslateAnimationByUpOrByDown(buttonsBarLinearLayout, false);
    }

    private void onSettingsButtonAction(){
        try{
            Utils.addRotateAnimation(mainSettingsButton, 0f, 360f);
            startActivity(new Intent(this, MainSettingsPage.class));
        }catch (Exception e){
            ErrorDialog.showDialog(this, e, true);
        }
    }
}
