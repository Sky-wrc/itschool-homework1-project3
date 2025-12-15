package com.amaykov.homework1.project3;

import android.content.Intent;
import android.graphics.Color;
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

        String[] quantities = {"Выберите:", "км", "м", "см"};

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
            if(number.getText().toString().isEmpty())
            {
                text1 = "ошибка";
                text2 = "Вы ничего не ввели";
            }
            else
                if(varFrom != "Выберите:" && varTo != "Выберите:")
                {
                    if(varFrom == varTo)
                    {
                        text1 = number.getText().toString() +" " + varFrom + " перевести в " + varTo + " будет:";
                        text2 = number.getText().toString();
                    }
                    else
                    {
                        if(varFrom == "км")
                            switch (varTo){
                                case "см":
                                    text1 = number.getText().toString() +" " + varFrom + " перевести в " + varTo + " будет:";
                                    text2 = String.valueOf(Double.parseDouble(number.getText().toString()) * 100_000)+" "+ varTo;
                                    break;
                                case "м":
                                    text1 = number.getText().toString() +" " + varFrom + " перевести в " + varTo + " будет:";
                                    text2 = String.valueOf(Double.parseDouble(number.getText().toString()) * 1000) +" "+ varTo;
                                    break;
                            }
                        if(varFrom == "см")
                            switch (varTo){
                                case "км":
                                    text1 = number.getText().toString() +" " + varFrom + " перевести в " + varTo + " будет:";
                                    text2 = String.valueOf(Double.parseDouble(number.getText().toString()) * 0.00001)+" "+ varTo;
                                    break;
                                case "м":
                                    text1 = number.getText().toString() +" " + varFrom + " перевести в " + varTo + " будет:";
                                    text2 = String.valueOf(Double.parseDouble(number.getText().toString()) * 0.01) +" "+ varTo;
                                    break;
                            }
                        if(varFrom == "м")
                            switch (varTo){
                                case "км":
                                    text1 = number.getText().toString() +" " + varFrom + " перевести в " + varTo + " будет:";
                                    text2 = String.valueOf(Double.parseDouble(number.getText().toString()) * 0.001)+" "+ varTo;
                                    break;
                                case "см":
                                    text1 = number.getText().toString() +" " + varFrom + " перевести в " + varTo + " будет:";
                                    text2 = String.valueOf(Double.parseDouble(number.getText().toString()) * 100) +" "+ varTo;
                                    break;
                            }

                    }
                }
                else
                {
                    text1 = "ошибка";
                    text2 = "Вы не выбрали что во что конвертировать";
                }

            intent.putExtra("KEY_STRING1", text1);
            intent.putExtra("KEY_STRING2", text2);

            startActivity(intent);
        }
    });

    }
}