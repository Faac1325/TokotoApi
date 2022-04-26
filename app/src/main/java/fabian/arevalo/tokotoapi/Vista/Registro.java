package fabian.arevalo.tokotoapi.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fabian.arevalo.tokotoapi.Interfaces.Interfaces;
import fabian.arevalo.tokotoapi.Presentador.Presentador;
import fabian.arevalo.tokotoapi.R;

public class Registro extends AppCompatActivity implements Interfaces.VistaRegistro {
    EditText etreemail, etpassword, etconfirpass;
    Button btnregistrar,btnatrasregistrar;
    Interfaces.PresentadorRegistro presenter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        etreemail = findViewById(R.id.etregmail);
        etpassword = findViewById(R.id.etpassword);
        etconfirpass = findViewById(R.id.etconfipass);
        btnregistrar = findViewById(R.id.btnregistrar);
        btnatrasregistrar=findViewById(R.id.btnatrasregistrar);
        presenter = new Presentador(this);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.recibirDatos(etreemail.getText().toString().trim(),etpassword.getText().toString().trim(),etconfirpass.getText().toString().trim(),Registro.this);
                ;
            }
        });

        btnatrasregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                ;
            }
        });


    }


    @Override
    public void mostrarMensaje(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        if(msg.equals("Usuario registrado exitosamente")){
        Intent i= new Intent(Registro.this,MainActivity.class);
        startActivity(i);
        }

    }
    //Bloquear atras
    @Override
    public void onBackPressed() {
        /*super.onBackPressed();*/
    }
}