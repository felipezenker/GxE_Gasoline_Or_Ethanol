package com.zenker.gxe_gasolineorethanol;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    private TextView gasolinePriceTextView;
    private TextView ethanolPriceTextView;
    private TextInputEditText bestFuel;
    private ImageView bestFuelImg;

    private double gasolinePrice= 2.50;
    private double ethanolPrice = 2.50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gasolinePriceTextView = findViewById(R.id.gasolinePriceTextView);
        ethanolPriceTextView = findViewById(R.id.ethanolPriceTextView);
        bestFuel = findViewById(R.id.bestFuel);
        bestFuelImg = findViewById(R.id.bestFuelImg);
        SeekBar gasolineSeekBar = findViewById(R.id.gasolineSeekBar);
        SeekBar ethanolSeekBar = findViewById(R.id.ethanolSeekBar);
        gasolineSeekBar.setOnSeekBarChangeListener(onGasolineSeekBarChangeListener);
        ethanolSeekBar.setOnSeekBarChangeListener(onEthanolSeekBarChangeListener);
    }

    private SeekBar.OnSeekBarChangeListener onGasolineSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            gasolinePrice = progress / 100D; //utilizando um D ou d alteramos o valor para double
            gasolinePriceTextView.setText(currencyFormat.format((gasolinePrice)));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if(ethanolPrice / gasolinePrice > 0.7)
            {
                bestFuel.setText(getString(R.string.gasoline));
                bestFuelImg.setImageResource(R.drawable.gasoline);
            }
            else
            {
                bestFuel.setText(getString(R.string.ethanol));
                bestFuelImg.setImageResource(R.drawable.ethanol);
            }
        }
    };

    private SeekBar.OnSeekBarChangeListener onEthanolSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            ethanolPrice = progress / 100D;
            ethanolPriceTextView.setText(currencyFormat.format(ethanolPrice));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if(ethanolPrice / gasolinePrice > 0.7)
            {
                bestFuel.setText(getString(R.string.gasoline));
                bestFuelImg.setImageResource(R.drawable.gasoline);
            }
            else
            {
                bestFuel.setText(getString(R.string.ethanol));
                bestFuelImg.setImageResource(R.drawable.ethanol);
            }
        }
    };
}
