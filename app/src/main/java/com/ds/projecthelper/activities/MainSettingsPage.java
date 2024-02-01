package com.ds.projecthelper.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.ds.projecthelper.R;
import com.ds.projecthelper.user.UserInformation;
import com.ds.projecthelper.util.AnotherActivity;
import com.ds.projecthelper.util.Colors;

import io.getstream.avatarview.AvatarView;

public class MainSettingsPage extends AppCompatActivity {
    private SearchView searchView;
    private TextView userNameText, dateOfRegistrationText;
    private AvatarView avatarView;
    private LinearLayout sendFeedbackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_settings_page);

        searchView = findViewById(R.id.searchView);
        userNameText = findViewById(R.id.userName);
        dateOfRegistrationText = findViewById(R.id.dateOfRegistration);
        avatarView = findViewById(R.id.avatarView);
        sendFeedbackButton = findViewById(R.id.sendFeedBackButton);

        initSearch(getResources().getStringArray(R.array.search_requests));

        avatarView.setAvatarInitials("TS");
        avatarView.setAvatarInitialsBackgroundColor(Colors.getRandomColor());

        sendFeedbackButton.setOnClickListener(click -> onSendFeedBackButton());
    }

    private void initSearch(String[] searchRequests) {
        ArrayAdapter<String> searchRequestsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, searchRequests);
        
    }

    public void loadUserData(@NonNull UserInformation userInformation){
        userNameText.setText(userInformation.getUserName());
        dateOfRegistrationText.setText(userInformation.getDateOfRegistration());
    }

    private void onSendFeedBackButton(){
        AnotherActivity.gotoAnotherActivity(this, FeedbacksBlock.class, false);
    }
}
