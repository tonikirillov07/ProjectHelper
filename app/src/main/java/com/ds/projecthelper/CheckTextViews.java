package com.ds.projecthelper;

import android.widget.EditText;

import androidx.annotation.NonNull;

import com.ds.projecthelper.dialogs.ErrorDialog;

public class CheckTextViews {
    public void checkField(@NonNull EditText editText, String fieldName, int minLength){
        try {
            if (checkField(editText, minLength))
                editText.setError("The length of " + fieldName + " must be not least then " + minLength + " symbols");
            else
                editText.setError("Enter the text");
        }catch (Exception e){
            ErrorDialog.showDialog(editText.getContext(), e, true);
        }
    }

    public boolean checkField(@NonNull EditText editText, int minLength){
        return !getFieldText(editText).isEmpty() & getFieldText(editText).length() <= minLength;
    }

    @NonNull
    private String getFieldText(@NonNull EditText editText){
        return editText.getText().toString().trim();
    }
}
