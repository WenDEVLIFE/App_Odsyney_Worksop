package com.example.grade_calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText english;
    EditText math;
    EditText mapeh;
    EditText science;
    EditText history;

    Button calculate;
    Button clear;

    double avg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        english = findViewById(R.id.EnglishInput);
        math = findViewById(R.id.Mathinput);
        mapeh = findViewById(R.id.Mapeh);
        science = findViewById(R.id.Science);
        history = findViewById(R.id.AralPan);

        calculate = findViewById(R.id.button);
        clear = findViewById(R.id.buttonclear);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.button){

            double num1 = Double.parseDouble( english.getText().toString());
            double num2 = Double.parseDouble( math.getText().toString());
            double num3 = Double.parseDouble(mapeh.getText().toString());
            double num4 = Double.parseDouble( science.getText().toString());
            double num5 = Double.parseDouble( history.getText().toString());


            double add = num1+ num2 + num3+ num4 + num5;

             avg = add / 5;

            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Alert Dialog");
            alertDialog.setMessage("Your average is:" + avg);


            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", (dialog, which)
                    -> Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show());

            alertDialog.show();


        }
        else if (v.getId()==R.id.buttonclear) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Alert Dialog");
            alertDialog.setMessage("You can now input new value.");


            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();

            english.setText("");
            math.setText("");
            mapeh.setText("");
            science.setText("");
            history.setText("");



        }

    }
}