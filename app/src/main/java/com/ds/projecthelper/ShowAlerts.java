package com.ds.projecthelper;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public abstract class ShowAlerts {
    public static void showDialog(Context context, @NonNull Exception e, boolean printFullInfo){
        Log.e(ShowAlerts.class.getSimpleName(), Arrays.toString(e.getStackTrace()));

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("An exception has occurred");
        alert.setMessage(printFullInfo ? e.toString(): e.getMessage());

        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
