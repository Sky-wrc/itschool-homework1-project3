package com.amaykov.homework1.project3;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;

import java.util.Objects;

public class ResultActivity extends AppCompatActivity {

    TextView TV1;
    TextView TV2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        Boolean isEr = Boolean.TRUE;
        String text1 = intent.getStringExtra("KEY_STRING1");
        String text2 = intent.getStringExtra("KEY_STRING2");
        if(Objects.equals(text1, "ошибка"))
            isEr = Boolean.FALSE;

        TV1 = findViewById(R.id.textView4);
        TV2 = findViewById(R.id.textView5);
        TV1.setText(text1);
        if(isEr)
            TV2.setTextSize(25);
        TV2.setText(text2);

    }
}