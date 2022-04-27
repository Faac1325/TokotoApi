package fabian.arevalo.tokotoapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import fabian.arevalo.tokotoapi.Conexionbd.AdminSQLiteOpenHelper;
import fabian.arevalo.tokotoapi.Interfaces.Interfaces;
import fabian.arevalo.tokotoapi.Presentador.Presentador;
import fabian.arevalo.tokotoapi.Vista.Inicio;
import fabian.arevalo.tokotoapi.Vista.MainActivity;
import fabian.arevalo.tokotoapi.Vista.Registro;

public class Olvidar extends AppCompatActivity implements Interfaces.VistaRegistro  {

    Button btnrecuperar,btnatrasolvidar;
    EditText emailolvidar;
    private Cursor fila;
    Bundle pass;

    Interfaces.PresentadorRegistro presenter;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidar);

        btnrecuperar = findViewById(R.id.btnrecuperar);
        emailolvidar = findViewById(R.id.emailolvidar);
        btnatrasolvidar=findViewById(R.id.btnatrasolvidar);
        pass = getIntent().getExtras();

        presenter = new Presentador(this);


        btnatrasolvidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                onBackPressed();

            }
        });

        btnrecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.recibirDatosRecuperar(emailolvidar.getText().toString().trim(),Olvidar.this);
            }
        });


    }


    //Bloquear atras
    @Override
    public void onBackPressed() {
        /*super.onBackPressed();*/
    }


    @Override
    public void mostrarMensaje(String msg) {
    System.out.println("dieog"+msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();




    }
}