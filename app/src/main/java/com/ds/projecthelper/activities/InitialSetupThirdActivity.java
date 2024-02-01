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

import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.R;
import com.ds.projecthelper.ShowAlerts;

import java.util.ArrayList;
import java.util.List;

public class InitialSetupThirdActivity extends AppCompatActivity {
    private Button nextButton;
    private LinearLayout scrollViewLinearLayout;
    private Typeface font;
    private final List<CheckBox> checkBoxes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_setup_third);

        scrollViewLinearLayout = findViewById(R.id.scrollViewLinearLayout);
        nextButton = findViewById(R.id.buttonNext);

        font = Typeface.create("Montserrat", Typeface.BOLD);

        nextButton.setOnClickListener(v -> nextButtonAction());
        pushInfoToList(getResources().getStringArray(R.array.PLs));
    }

    private void pushInfoToList(String[] infoList) {
        for(String PLName : infoList) {
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

    private void nextButtonAction(){
        if(checkBoxesWereChecked()){
            Intent intent = new Intent(this, MainPage.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        } else {
            ShowAlerts.showDialog(this, new Exception(getResources().getString(R.string.select_at_least_one_pl)), false);
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
