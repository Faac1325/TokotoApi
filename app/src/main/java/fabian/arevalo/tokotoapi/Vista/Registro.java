package fabian.arevalo.tokotoapi.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import fabian.arevalo.tokotoapi.Interfaces.Interfaces;
import fabian.arevalo.tokotoapi.Presentador.Presentador;
import fabian.arevalo.tokotoapi.R;

public class Registro extends AppCompatActivity implements Interfaces.VistaRegistro {
    EditText etreemail, etpassword, etconfirpass;
    Button btnregistrar;
    ImageButton btngoogle,btnfacebook,btntwitter;
    Interfaces.PresentadorRegistro presenter;
    Context context;

    String url_go = "https://www.google.com/";
    String  url_fa= "https://www.facebook.com/";
    String url_tw= "https://www.twitter.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        etreemail = findViewById(R.id.etregmail);
        etpassword = findViewById(R.id.etpassword);
        etconfirpass = findViewById(R.id.etconfipass);
        btnregistrar = findViewById(R.id.btnregistrar);
        btngoogle=findViewById(R.id.btngoogle);
        btnfacebook= findViewById(R.id.btnfacebook);
        btntwitter=findViewById(R.id.btntwitter);


        presenter = new Presentador(this);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.recibirDatos(etreemail.getText().toString().trim(),etpassword.getText().toString().trim(),etconfirpass.getText().toString().trim(),Registro.this);
                ;
            }
        });

        btngoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri urlg = Uri.parse(url_go);
                Intent i3 = new Intent(Intent.ACTION_VIEW, urlg);
                startActivity(i3);
            }
        });
        btnfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri urlg = Uri.parse(url_fa);
                Intent i3 = new Intent(Intent.ACTION_VIEW, urlg);
                startActivity(i3);
            }
        });
        btntwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri urlg = Uri.parse(url_tw);
                Intent i3 = new Intent(Intent.ACTION_VIEW, urlg);
                startActivity(i3);
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
    public void regresar(View view){
        onBackPressed();
    }
}