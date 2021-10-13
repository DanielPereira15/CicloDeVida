package com.example.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int contador =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView cajaTexto = findViewById(R.id.textView);
        Toast.makeText(this,"onCreate actividad ya creada",Toast.LENGTH_SHORT).show();
    }
    public void incrementar(View v){

        TextView cajaTexto = findViewById(R.id.textView);
        cajaTexto.setText("0");
        cajaTexto.setText(""+contador);
        contador++;
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