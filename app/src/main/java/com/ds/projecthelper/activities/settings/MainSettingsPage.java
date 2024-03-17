package com.ds.projecthelper.activities.settings;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.ds.projecthelper.R;
import com.ds.projecthelper.dialogs.ErrorDialog;
import com.ds.projecthelper.user.UserController;
import com.ds.projecthelper.user.UserInformation;
import com.ds.projecthelper.util.AnotherActivity;
import com.ds.projecthelper.util.Colors;
import com.ds.projecthelper.util.Utils;

import io.getstream.avatarview.AvatarView;

public class MainSettingsPage extends AppCompatActivity {
    private SearchView searchView;
    private TextView userNameText, dateOfRegistrationText, goToUserSettings;
    private AvatarView avatarView;
    private LinearLayout sendFeedbackButton, resetSettingsButton, appearanceButton, aboutButton, moreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_settings_page);

            searchView = findViewById(R.id.searchView);
            userNameText = findViewById(R.id.userName);
            dateOfRegistrationText = findViewById(R.id.dateOfRegistration);
            avatarView = findViewById(R.id.avatarView);
            sendFeedbackButton = findViewById(R.id.sendFeedBackButton);
            resetSettingsButton = findViewById(R.id.resetSettingsButton);
            appearanceButton = findViewById(R.id.appearanceButton);
            aboutButton = findViewById(R.id.aboutButton);
            moreButton = findViewById(R.id.moreButton);
            goToUserSettings = findViewById(R.id.gotoUserSettings);

            initButtons();

            initSearch(getResources().getStringArray(R.array.search_requests));
            loadUserData(UserController.getUserInformation());
        }catch (Exception e){
            ErrorDialog.showDialog(this, e, true);
        }
    }

    private void initButtons() {
        try{
            sendFeedbackButton.setOnClickListener(click -> Utils.onSettingButtonClick(sendFeedbackButton, this::onSendFeedBackButton));
            resetSettingsButton.setOnClickListener(click -> Utils.onSettingButtonClick(resetSettingsButton, () -> {}));
            appearanceButton.setOnClickListener(click -> Utils.onSettingButtonClick(appearanceButton, () -> {}));
            aboutButton.setOnClickListener(click -> Utils.onSettingButtonClick(aboutButton, () -> AnotherActivity.gotoAnotherActivity(this, AboutSettingsBlock.class, false)));
            moreButton.setOnClickListener(click -> Utils.onSettingButtonClick(moreButton, () -> {}));

            goToUserSettings.setOnClickListener(click -> AnotherActivity.gotoAnotherActivity(this, MainSettingsUserBlock.class, false));
        }catch (Exception e){
            ErrorDialog.showDialog(this, e, true);
        }
    }

    private void initSearch(String[] searchRequests) {
        ArrayAdapter<String> searchRequestsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, searchRequests);
        
    }

    public void loadUserData(@NonNull UserInformation userInformation){
        userNameText.setText(userInformation.getUserName());

        avatarView.setAvatarInitials(userInformation.getUserName());
        avatarView.setAvatarInitialsBackgroundColor(Colors.getRandomColor());
    }

    private void onSendFeedBackButton(){
        AnotherActivity.gotoAnotherActivity(this, FeedbacksBlock.class, false);
    }


}
