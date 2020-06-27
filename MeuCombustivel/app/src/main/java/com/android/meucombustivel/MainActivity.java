package com.android.meucombustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private EditText campoNome;
    private TextView result, resultadoCor;
    private TextInputEditText emailCampo;

    private CheckBox vermelho, verde, branco;

    private RadioButton masculino, feminino;
    private RadioGroup opcaoGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = findViewById(R.id.nome_id);
        result = findViewById(R.id.result_id);
        emailCampo = findViewById(R.id.email_id);
        resultadoCor = findViewById(R.id.resultCor);

        vermelho = findViewById(R.id.vermelho);
        verde = findViewById(R.id.verde);
        branco = findViewById(R.id.branco);

        masculino = findViewById(R.id.RBmasculino);
        feminino = findViewById(R.id.RBFeminino);
        opcaoGenero = findViewById(R.id.opcaoGenero);

        radioButton();
    }

    public void checked(){
        String textoCor = "";
        if (vermelho.isChecked()){
//            String opcaoDeCor = vermelho.getText().toString();
//            textoCor = opcaoDeCor;
          textoCor = "Vermelho Selecionado - ";
        }if (verde.isChecked()){
            textoCor = "Verde Selecionado - ";
        }if (branco.isChecked()){
            textoCor = "Branco Selecionado";
        }

         resultadoCor.setText(textoCor);

    }

    public void radioButton(){
        opcaoGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.RBmasculino){
                    resultadoCor.setText("Masculino selecionado");
                }if (checkedId == R.id.RBFeminino){
                    resultadoCor.setText("Feminino selecionado");
                }
            }
        });


//        if (masculino.isChecked()){
//            resultadoCor.setText("Masculino selecionado");
//        }else if(feminino.isChecked()){
//            resultadoCor.setText("Feminino selecionado");
//        }
    }

    public void enviar(View view){

  //   radioButton();

     //   checked();

//        String nome = campoNome.getText().toString();
//        String email = emailCampo.getText().toString();
//        result.setText("Nome: " + nome + "- Email: " + email);
    }

    public void limpar(View view){
        campoNome.setText("");
        emailCampo.setText("");
    }
}
