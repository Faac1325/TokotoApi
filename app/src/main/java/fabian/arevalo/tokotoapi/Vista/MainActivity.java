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
import android.widget.TextView;
import android.widget.Toast;

import fabian.arevalo.tokotoapi.Interfaces.Interfaces;
import fabian.arevalo.tokotoapi.Olvidar;
import fabian.arevalo.tokotoapi.Presentador.Presentador;
import fabian.arevalo.tokotoapi.R;

public class MainActivity extends AppCompatActivity implements Interfaces.VistaRegistro{
    EditText etmail,etpass;
    Button btnlogin,btnatraslogin;
    ImageButton btngoogle,btnfacebook,btntwitter;
    TextView tvinscribete,tvolvidar;
    Context context;
    Interfaces.PresentadorRegistro presenter;

    String url_go = "https://www.google.com/";
    String  url_fa= "https://www.facebook.com/";
    String url_tw= "https://www.twitter.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etmail=findViewById(R.id.etmail);
        etpass=findViewById(R.id.etpass);
        btnlogin=findViewById(R.id.btnlogin);
        tvinscribete=findViewById(R.id.tvinscribete);
        btnatraslogin=findViewById(R.id.btnatraslogin);
        btngoogle=findViewById(R.id.btngoogle);
        btnfacebook= findViewById(R.id.btnfacebook);
        btntwitter=findViewById(R.id.btntwitter);


        tvolvidar=findViewById(R.id.tvolvidar);


        presenter = new Presentador(this);



        //Este nos envia de MainActivity a Registro
        tvinscribete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Registro.class);
                startActivity(i);
                onBackPressed();
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.recibirDatosLogin(etmail.getText().toString().trim(),etpass.getText().toString().trim(),MainActivity.this);
                ;
            }
        });
        btnatraslogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this, Splash_screen.class);
                startActivity(i);
                onBackPressed();

            }
        });

        tvolvidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,Olvidar.class);
                startActivity(i);
                finish();

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
        if(msg.equals("Bienvenido")) {
            Intent i= new Intent(MainActivity.this,Inicio.class);
            startActivity(i);
        }

    }
    //Bloquear atras
    @Override
    public void onBackPressed() {
        /*super.onBackPressed();*/
    }


}