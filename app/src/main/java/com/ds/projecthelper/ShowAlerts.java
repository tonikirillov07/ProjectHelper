package com.ds.projecthelper;

import android.app.AlertDialog;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public class ShowAlerts {
    public void showDialog(Context context, Exception e){
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("An exception has occurred");
        alert.setMessage(e.toString());

        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
