package com.ds.projecthelper.util;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.ds.projecthelper.ShowAlerts;

public abstract class AnotherActivity {
    public static void gotoAnotherActivity(AppCompatActivity appCompatActivity, Class activityClass, boolean destroyPreviousActivity){
        try {
            Intent intent = new Intent(appCompatActivity, activityClass);
            if(destroyPreviousActivity) intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            appCompatActivity.startActivity(intent);
            appCompatActivity.finish();
        }catch (Exception e){
            ShowAlerts.showDialog(appCompatActivity, e, true);
        }
    }
}
