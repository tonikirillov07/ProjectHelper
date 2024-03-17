package com.ds.projecthelper.activities.settings;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.R;
import com.ds.projecthelper.dialogs.ConfirmDialog;
import com.ds.projecthelper.dialogs.ErrorDialog;
import com.ds.projecthelper.activities.initialSetup.InitialSetupSecondActivity;
import com.ds.projecthelper.user.UserController;
import com.ds.projecthelper.util.AnotherActivity;
import com.ds.projecthelper.util.Utils;

import java.util.Objects;

import io.getstream.avatarview.AvatarView;

public class MainSettingsUserBlock extends AppCompatActivity {
    private TextView userNameTextView, dateOfRegTextView;
    private LinearLayout deleteAccountButton, logOutAccountButton;
    private AvatarView avatarView;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_settings_user_block_page);

            userNameTextView = findViewById(R.id.userNameTextView);
            dateOfRegTextView = findViewById(R.id.dateOfRegTextView);
            deleteAccountButton = findViewById(R.id.deleteAccountButton);
            logOutAccountButton = findViewById(R.id.logOutButton);
            avatarView = findViewById(R.id.userAvatar);
            backButton = findViewById(R.id.backButton);

            initUserData();
            initButtons();
        }catch (Exception e){
            ErrorDialog.showDialog(this, e, true);
        }
    }

    private void initUserData() {
        try{
            String userEmail = Objects.requireNonNull(UserController.getInstance().getFirebaseAuth().getCurrentUser()).getEmail();

            userNameTextView.setText(userEmail);
            avatarView.setAvatarInitials(userEmail);
        }catch (Exception e){
            ErrorDialog.showDialog(this, e, true);
        }
    }

    private void initButtons() {
        try{
            deleteAccountButton.setOnClickListener(click -> Utils.onSettingButtonClick(deleteAccountButton, () -> ConfirmDialog.showDialog(this, getResources().getString(R.string.account_deleting_confirm), () -> {
                Objects.requireNonNull(UserController.getInstance().getFirebaseAuth().getCurrentUser()).delete();
                openLogInActivity();
            }, android.R.drawable.ic_dialog_alert)));

            logOutAccountButton.setOnClickListener(click -> Utils.onSettingButtonClick(logOutAccountButton, () -> {
                UserController.logOut();
                openLogInActivity();
            }));

            backButton.setOnClickListener(click -> AnotherActivity.gotoAnotherActivity(this, MainSettingsPage.class, false));
        }catch (Exception e){
            ErrorDialog.showDialog(this, e, true);
        }
    }

    private void openLogInActivity(){
        AnotherActivity.gotoAnotherActivity(this, InitialSetupSecondActivity.class, true);
    }
}
