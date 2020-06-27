package com.android.calculargorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private SeekBar  seekbar;
    private TextInputEditText valor;
    private TextView gorjeta;
    private TextView total;
    private TextView porcetagem;
    private double resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     seekbar = findViewById(R.id.seekBar);
     valor = findViewById(R.id.editarValor);
     gorjeta = findViewById(R.id.editgorjeta);
     total = findViewById(R.id.total);
     porcetagem = findViewById(R.id.porcentagem);

     seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

         @Override
         public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            resultado = progress;
            porcetagem.setText(Math.round(resultado) + "%");
             calcularGorjeta();
         }

         @Override
         public void onStartTrackingTouch(SeekBar seekBar) {

         }

         @Override
         public void onStopTrackingTouch(SeekBar seekBar) {

         }
     });

    }

    public void calcularGorjeta(){
        String valorGorjeta = valor.getText().toString();
        if (valorGorjeta == null || valorGorjeta.equals("") ){
            Toast.makeText(getApplicationContext(), "Digite um valor", Toast.LENGTH_LONG).show();
        }else{
            double valorDigitado = Double.parseDouble(valorGorjeta);
            double vGorjeta = valorDigitado * (resultado / 100);
            double vtotal = valorDigitado + vGorjeta;
            gorjeta.setText("R$ " + Math.round(vGorjeta));
            total.setText("R$ " +  Math.round(vtotal));
        }
    }
}
