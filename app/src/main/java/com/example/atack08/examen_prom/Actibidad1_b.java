package com.example.atack08.examen_prom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Actibidad1_b extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actibidad1_b);

        //RESCATAMOS INTENT
        Intent intent = getIntent();

        //RESCATAMOS VARIABLES DEL INTENT
        String nombre = intent.getStringExtra("nombre");
        String provincia = intent.getStringExtra("provincia");
        String sexo = intent.getStringExtra("sexo");
        String conocimientos = intent.getStringExtra("conocimientos");

        //IMPRIMIMOS EN PANTALLA
        ((TextView)findViewById(R.id.lblResultNombre)).setText(nombre);
        ((TextView)findViewById(R.id.lablResultProvincia)).setText(provincia);
        ((TextView)findViewById(R.id.lblResulConocimientos)).setText(conocimientos);
        ((TextView)findViewById(R.id.lblResulSexo)).setText(sexo);


    }

    //SI SE PULSA ACEPTAR
    public void aceptar(View v){
        Intent intent = new Intent(this, Actividad1.class);
        intent.putExtra("respuesta",true);
        this.setResult(1,intent);
        finish();
    }

    //SI SE PULSA RECHAZAR
    public void rechazar(View v){
        Intent intent = new Intent(this, Actividad1.class);
        intent.putExtra("respuesta",false);
        this.setResult(1,intent);
        finish();
    }
}
