package com.luc.exercicecours1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int max = 10;
    private Cacou cacou;

    private EditText inputNumber;
    private Button buttonTry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.editText_nbr1);

        buttonTry = findViewById(R.id.button_compare);

        cacou = new Cacou(max);
        setListenner();
    }

    private void setListenner()
    {
        buttonTry.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                guess();
            }
        });
    }

    private void guess()
    {
        int numberToTest =Integer.parseInt(inputNumber.getText().toString());
        Cacou.guessState result = cacou.testNumber(numberToTest);

        if ( result == Cacou.guessState.BIGGER )
        {
            showHint("+ grand");
        }
        else  if(result == Cacou.guessState.SMALLER)
        {
            showHint("+ petit");
        }
        else
            {
                showHint("Bravo");
            }
    }

    private void showHint(String hint)
    {
        Toast.makeText(this,hint, Toast.LENGTH_SHORT).show();
    }
}
