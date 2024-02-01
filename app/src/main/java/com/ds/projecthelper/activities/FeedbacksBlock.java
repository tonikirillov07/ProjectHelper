package com.ds.projecthelper.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.R;
import com.ds.projecthelper.ShowAlerts;
import com.ds.projecthelper.util.AnotherActivity;
import com.google.android.material.slider.Slider;

public class FeedbacksBlock extends AppCompatActivity {
    private EditText summarizeFeedbackTextField, explainFeedbackTextField;
    private Button buttonNext, buttonRate;
    private Slider sliderRate;
    private boolean isSliderRateWasInteract = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_settings_feedbacks_block_page);

        summarizeFeedbackTextField = findViewById(R.id.summarizeYourFeedbackTextField);
        explainFeedbackTextField = findViewById(R.id.explainFeedbackTextField);
        buttonNext = findViewById(R.id.buttonNext);
        buttonRate = findViewById(R.id.buttonRate);
        sliderRate = findViewById(R.id.ratingSlider);

        buttonNext.setOnClickListener(click -> sendFeedbackButtonAction());
        buttonRate.setOnClickListener(click -> onRateButton());
        sliderRate.addOnChangeListener((slider, value, fromUser) -> isSliderRateWasInteract = fromUser);

    }

    private void sendFeedbackButtonAction(){
        if(!checkFeedback()) {
            return;
        }

        AnotherActivity.gotoAnotherActivity(this, ThanksForFeedbackActivity.class, false);

        summarizeFeedbackTextField.getText().clear();
        explainFeedbackTextField.getText().clear();
    }

    private boolean checkFeedback(){
        boolean isSummarizeFeedbackFieldIsEmpty = summarizeFeedbackTextField.getText().toString().isEmpty();
        boolean isExplainFeedbackFieldIsEmpty = explainFeedbackTextField.getText().toString().isEmpty();
        boolean result = !isSummarizeFeedbackFieldIsEmpty & !isExplainFeedbackFieldIsEmpty;

        if(!result){
            if(isSummarizeFeedbackFieldIsEmpty){
                fillThisFieldAlert(summarizeFeedbackTextField);
            }

            if(isExplainFeedbackFieldIsEmpty){
                fillThisFieldAlert(explainFeedbackTextField);
            }
        }

        return result;
    }

    private void fillThisFieldAlert(@NonNull EditText editText){
        editText.setError(getResources().getString(R.string.fill_in_this_field));
    }

    private void onRateButton(){
        if(isSliderRateWasInteract) AnotherActivity.gotoAnotherActivity(this, ThanksForFeedbackActivity.class, false);
        else ShowAlerts.showDialog(this, new Exception("Rate app using slider"), false);
    }
}
