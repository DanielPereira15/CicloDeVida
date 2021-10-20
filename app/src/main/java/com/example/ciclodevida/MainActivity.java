package com.example.ciclodevida;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int contador;
    private static final String KEY_CONTADOR="key_contador_tv";
    private static final String KEY_COLOR ="key_color";
    TextView cajaTexto;
    int color;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"onCreate actividad ya creada",Toast.LENGTH_SHORT).show();
        contador =0;
        cajaTexto = findViewById(R.id.textView);
        cajaTexto.setText(""+contador);
        //PARA CAPTURAR EL EVENTO PULSACION LARGA DEL BOTON....
        btn=findViewById(R.id.button);
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                contador=0;
                cajaTexto.setText(""+contador);
                cajaTexto.setBackgroundColor(0);
                return true;
                //si ponemos true no tiene en cuanta el click y no llama a incrementa, se queda a 0. Con false al soltar se pone 1
            }
        });

/*
        if(savedInstanceState != null){
            contador = savedInstanceState.getInt(KEY_CONTADOR);
            cajaTexto.setText(""+contador);
        }
 */

    }

    public void incrementar(View v){
        contador++;
        cajaTexto.setText(""+contador);
        Random r= new Random();
        color = Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256));
        cajaTexto.setBackgroundColor(color);
        comprueba5();
    }
   public void comprueba5(){
        if (contador==5){
            Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(500);
        }
   }



//metodo para salvar lo que queramos de la instancia
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CONTADOR,contador);
        outState.putInt(KEY_COLOR,color);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        contador=savedInstanceState.getInt(KEY_CONTADOR,0);
        color=savedInstanceState.getInt(KEY_COLOR,0);
        cajaTexto.setText(""+contador);
        cajaTexto.setBackgroundColor(color);

    }



    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this,"onStart actividad esta a punto de hacerse visible",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this,"onResume actividad ya visible",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this,"onPause actividad a punto de ser detenida",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this,"onStop actividad ya no es visible, esta detenida",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"onDestroy actividad a punto de ser destruida",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this,"onRestart actividad restaurada",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Toast.makeText(this,"onBackPressed se ha pulsado el boton atras",Toast.LENGTH_SHORT).show();

    }


}