package com.amaykov.homework1.project3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;

import android.content.Intent;
import android.content.Context;

public class ConverterActivity extends AppCompatActivity {

    Spinner from;
    Spinner to;
    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        from = findViewById(R.id.spinner2);
        to = findViewById(R.id.spinner);
        number = findViewById(R.id.editTextNumberDecimal);
        Button convert = findViewById(R.id.button);

        String[] quantities = {"Выберите:", "Километр", "Метр", "Сантиметр"};

        ArrayAdapter<String> adapter = new ArrayAdapter<> (this, android.R.layout.simple_spinner_item, quantities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from.setAdapter(adapter);
        to.setAdapter(adapter);


        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                }
                else {
                    String selectedItem = (String) parent.getItemAtPosition(position);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            

            Intent intent = new Intent(ConverterActivity.this, ResultActivity.class);
            String text1="";
            String text2="";
            String varFrom = from.getSelectedItem().toString();
            String varTo = to.getSelectedItem().toString();
            if(varFrom != "Выберите:" && varTo != "Выберите:")
            {
                if(varFrom == varTo)
                {
                    text1 = number.getText().toString() +" " + varFrom + " перевести в " + varTo + " будет:";
                    text2 = number.getText().toString();
                }
            }
            else
            {
                text1 = "ошибка";
                text2 = "Вы не выбрали что во что конвертировать";
            }
            if(number.getText().toString().isEmpty())
            {
                text1 = "ошибка";
                text2 = "Вы ничего не ввели";
            }
            intent.putExtra("KEY_STRING1", text1);
            intent.putExtra("KEY_STRING2", text2);

            startActivity(intent);
        }
    });

    }
}