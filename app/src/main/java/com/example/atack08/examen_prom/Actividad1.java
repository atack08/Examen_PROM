package com.example.atack08.examen_prom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad1 extends AppCompatActivity {

    private Spinner spinnerProvincias;
    private String nombre;
    private int resultado, n1,n2, fallos, admitidos;

    private  CheckBox check1, check2, check3, check4;

    final String[] provincias = new String[]{
            "Álava","Madrid","Alicante","Cuenca","Guadalajara"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        spinnerProvincias =  (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,provincias);

        spinnerProvincias.setAdapter(adaptador);

        //NÚMEROS ALEATORIOS
        int admitidos = 0;
        n1 = (int)(Math.random()*100)+1;
        n2 = (int)(Math.random()*100)+1;
        fallos = 0;
        resultado = n1 + n2;
        ((TextView)findViewById(R.id.operacionNum1)).setText(String.valueOf(n1));
        ((TextView)findViewById(R.id.operacionNum2)).setText(String.valueOf(n2));

        //CHECKS
         check1 = (CheckBox)findViewById(R.id.ch1);
         check2 = (CheckBox)findViewById(R.id.ch2);
         check3 = (CheckBox)findViewById(R.id.ch3);
         check4 = (CheckBox)findViewById(R.id.ch4);




    }


    public void evaluar(View v){

        this.nombre = ((EditText)findViewById(R.id.lblNombre)).getText().toString();
        String res =((EditText)findViewById(R.id.resultado)).getText().toString();
        String sexo="";

        //COMPROBAMOS CAMPOS OBLIGATORIOS
        if(nombre.equals("") || res.equals(""))
            Toast.makeText(this, "Faltan campos obligatorios", Toast.LENGTH_SHORT).show();
        else{

            //PROVNCIA
            String provincia = spinnerProvincias.getSelectedItem().toString();


            //SEXO
            if(((RadioButton)findViewById(R.id.radioMasculino)).isChecked())
                sexo = "Masculino";
            else{
                if(((RadioButton)findViewById(R.id.radioFemenino)).isChecked())
                    sexo = "Femenino";
            }

            //CONFECCIONAMOS LA CADENA CONOCIMIENTOS SEGÚN SE HAYAN SELECCIONADO
            String conocimientos = "";
            if(check1.isChecked())
                conocimientos += check1.getText().toString() + " ";
            if(check2.isChecked())
                conocimientos += check2.getText().toString() + " ";
            if(check3.isChecked())
                conocimientos += check3.getText().toString() + " ";
            if(check4.isChecked())
                conocimientos += check4.getText().toString( ) + " ";


            //COMPROBAMOS LA SUMA
            int resultIntroducido = Integer.parseInt(res);
            if(resultIntroducido != this.resultado) {
                fallos++;
                if(fallos == 3){
                    //SI LLEGAMOS A 3 FALLOS SALE
                    Toast.makeText(this, "NÚMERO DE FALLOS MÁXIMOS PERMITIDOS", Toast.LENGTH_SHORT).show();
                    this.finish();
                }
                    
            }
            else{
                //SI EL RESULTADO ES CORRECTO ABRIMOS LA ACTIVIDAD Y LE PASAMOS PARÁMETROS
                Intent intent = new Intent(this, Actibidad1_b.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("provincia", provincia);
                intent.putExtra("sexo", sexo);
                intent.putExtra("conocimientos",conocimientos);

                startActivityForResult(intent,2);
            }


        }
    }

    @Override
    public void onActivityResult(int codigoRequest, int codigoResultado, Intent intentRespuesta) {

        super.onActivityResult(codigoResultado, codigoResultado, intentRespuesta);
        Bundle b = intentRespuesta.getExtras();

        //RESETEAMOS FALLOS Y SUMA
        this.fallos = 0;
        n1 = (int)(Math.random()*100)+1;
        n2 = (int)(Math.random()*100)+1;
        resultado = n1 + n2;
        ((TextView)findViewById(R.id.operacionNum1)).setText(String.valueOf(n1));
        ((TextView)findViewById(R.id.operacionNum2)).setText(String.valueOf(n2));

        //OBTENEMOS RESPUESTA DE LA ACTIVITY
        boolean respuesta = b.getBoolean("respuesta");
        if(respuesta)
            admitidos ++;

        ((TextView)findViewById(R.id.numCAndidatos)).setText(String.valueOf(this.admitidos));

        if (admitidos == 4) {
            ((Button)findViewById(R.id.botonEvaluar)).setVisibility(View.INVISIBLE);
            ((Button)findViewById(R.id.botonsalir)).setVisibility(View.VISIBLE);
        }

    }

    //MÉTODO PARA SALIR
    public void salir(View v){
        finish();
    }


}
