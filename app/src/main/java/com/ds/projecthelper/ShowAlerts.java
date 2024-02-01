package com.ds.projecthelper;

import android.app.AlertDialog;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public abstract class ShowAlerts {
    public static void showDialog(Context context, Exception e, boolean printFullInfo){
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("An exception has occurred");
        alert.setMessage(printFullInfo ? e.toString(): e.getMessage());

        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
