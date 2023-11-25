package com.ds.projecthelper;

import android.widget.EditText;

public class CheckTextViews {
    public void checkField(EditText editText, String title, int minLength){
        String textViewString = editText.getText().toString().trim();

        if(!textViewString.isEmpty()) {
            if (textViewString.length() < minLength)
                editText.setError("The length of " + title + " must be not least then " + minLength + " symbols");
        }else editText.setError("Enter the text");
    }
}
