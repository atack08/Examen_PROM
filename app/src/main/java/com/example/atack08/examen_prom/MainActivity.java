package com.example.atack08.examen_prom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //MÉTODO PARA MOSTRAR EL MENSAJE DE ACTIVIDAD NO IMPLEMENTADA
    public void mostrarMensajeError(View v){

        String msg = ((TextView)findViewById(R.id.mensajeT)).getText().toString();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    //MÉTODOS PARA REDIRIGIR ACTIVIDADES
    public void irActividad1(View v){

        Intent intent = new Intent(this, Actividad1.class);

        startActivity(intent);

    }
}
