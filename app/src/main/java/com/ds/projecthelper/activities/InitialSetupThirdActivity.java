package com.ds.projecthelper.activities;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.R;
import com.ds.projecthelper.ShowAlerts;

import java.util.ArrayList;
import java.util.List;

public class InitialSetupThirdActivity extends AppCompatActivity {
    private Button nextButton;
    private ScrollView scrollView;
    private LinearLayout scrollViewLinearLayout;
    private Typeface font;
    private String[] plsList;
    private final List<CheckBox> checkBoxes = new ArrayList<>();
    private ShowAlerts showAlerts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_setup_third);

        scrollViewLinearLayout = findViewById(R.id.scrollViewLinearLayout);
        scrollView = findViewById(R.id.plsScrollView);
        nextButton = findViewById(R.id.buttonNext);

        showAlerts = new ShowAlerts();
        plsList = getResources().getStringArray(R.array.PLs);
        font = Typeface.create("Montserrat", Typeface.BOLD);

        nextButton.setOnClickListener(v -> {
            if(checkBoxesWereChecked()){
                Intent intent = new Intent(this, MainPage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            } else {
                showAlerts.showDialog(this, new Exception("Choose at least one programming language from the offered. This is necessary to complete the initial setup"));
            }
        });

        pushInfoToList();
    }

    private void pushInfoToList() {
        for(String PLName : plsList) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(PLName);
            checkBox.setChecked(false);
            checkBox.setTextColor(Color.parseColor("#ffffff"));
            checkBox.setPadding(5, 0, 0, 0);
            checkBox.setTypeface(font);
            checkBox.setTextSize(14);
            checkBox.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(20, 50, 0, 15);

            checkBox.setLayoutParams(layoutParams);
            scrollViewLinearLayout.addView(checkBox);

            checkBoxes.add(checkBox);
        }
    }

    private boolean checkBoxesWereChecked(){
        int counter = 0;

        for(CheckBox checkBox : checkBoxes){
            if(checkBox.isChecked()) counter++;
        }

        return counter > 0;
    }
}
