package com.ds.projecthelper.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.R;

public class ExceptionsActivity extends AppCompatActivity {
    private TextView exceptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exception_info_page);

        exceptionText = findViewById(R.id.exceptionInfo);

        Button buttonOk = findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(v -> finish());
    }

    public TextView getExceptionText() {
        return exceptionText;
    }
}
