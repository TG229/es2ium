package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button incremento, decremento;
    EditText input;
    SeekBar seekBar;

    private final static int min = 0;
    private final static int max = 100;

    private int value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incremento = findViewById(R.id.incremento);
        decremento = findViewById(R.id.decremento);
        input = findViewById(R.id.input);
        seekBar = findViewById(R.id.seek_bar);

        UpdateValue(value);

        input.setText(Integer.toString(value));


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                UpdateValue(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                UpdateValue(seekBar.getProgress());
            }
        });

        incremento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateValue(value+1);
            }
        });

        decremento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateValue(value-1);
            }
        });
    }

    void UpdateValue(int newValue){
        value = newValue < min ? value : (newValue > max ? value : newValue);
        input.setText(Integer.toString(value));
        if(value == newValue){
            if(this.seekBar.getProgress() != newValue){
                this.seekBar.setProgress(newValue);
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}