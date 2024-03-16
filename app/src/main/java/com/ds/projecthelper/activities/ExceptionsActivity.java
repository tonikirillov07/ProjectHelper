package com.ds.projecthelper.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ds.projecthelper.Constants;
import com.ds.projecthelper.R;

import java.util.Objects;

public class ExceptionsActivity extends AppCompatActivity {
    private TextView exceptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exception_info_page);

        exceptionText = findViewById(R.id.exceptionInfo);

        Button buttonOk = findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(v -> finish());

        setException(new Exception(Objects.requireNonNull(getIntent().getExtras()).getString(Constants.EXCEPTION_KEY)));
    }

    public TextView getExceptionText() {
        return exceptionText;
    }

    private void setException(@NonNull Exception e){
        exceptionText.setText(e.toString());
    }
}
