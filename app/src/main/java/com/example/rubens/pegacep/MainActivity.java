package com.example.rubens.pegacep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buscar = (Button)findViewById(R.id.btnBuscar);






        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AcessoRest ar = new AcessoRest();

                EditText cepDigitado = (EditText)findViewById(R.id.editText);

                String chamada = ("https://viacep.com.br/ws/"+cepDigitado.getText()+"/json");

                String resultado = ar.exemploGet(chamada);

                try {
                    JSONObject json = new JSONObject(resultado);

                    TextView cep = (TextView)findViewById(R.id.tvCep);
                    cep.setText(json.getString("cep"));

                    TextView rua = (TextView)findViewById(R.id.tvRua);
                    rua.setText(json.getString("logradouro"));

                    TextView bairro = (TextView)findViewById(R.id.tvBairro);
                    bairro.setText(json.getString("bairro"));

                    TextView cidade = (TextView)findViewById(R.id.tvCidade);
                    cidade.setText(json.getString("localidade"));

                    TextView estado = (TextView)findViewById(R.id.tvEstado);
                    estado.setText(json.getString("uf"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }



}
