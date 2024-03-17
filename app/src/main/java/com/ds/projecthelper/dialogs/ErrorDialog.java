package com.ds.projecthelper.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Arrays;

public final class ErrorDialog {
    public static void showDialog(Context context, @NonNull Exception exception, boolean printFullInfo){
        makeErrorLog(exception);

        try {
            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("An exception has occurred");
            alert.setMessage(printFullInfo ? exception.toString() : exception.getMessage());

            AlertDialog dialog = alert.create();
            dialog.show();
        }catch (Exception e){
            makeErrorLog(e);
        }
    }

    private static void makeErrorLog(Exception e){
        Log.e(ErrorDialog.class.getSimpleName(), Arrays.toString(e.getStackTrace()));
    }
}
