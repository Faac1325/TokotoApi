package fabian.arevalo.tokotoapi.Vista;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fabian.arevalo.tokotoapi.R;

public class Inicio extends AppCompatActivity {
    Button btnatrasinicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        btnatrasinicio=findViewById(R.id.btnatrasinicio);
        tvsalir();



    }















    //Metodo salir
    public void tvsalir(){
        btnatrasinicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(Inicio.this);
                alerta.setMessage("Desea salir")
                        .setCancelable(false)

                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //onBackPressed();
                                Intent i1=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(i1);

                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog titulo= alerta.create();
                titulo.setTitle("Desea Salir");
                titulo.show();


            }
        });
    }
    //Bloquear atras
    @Override
    public void onBackPressed() {
        /*super.onBackPressed();*/
    }



}