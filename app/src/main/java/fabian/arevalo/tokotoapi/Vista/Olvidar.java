package fabian.arevalo.tokotoapi.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fabian.arevalo.tokotoapi.Interfaces.Interfaces;
import fabian.arevalo.tokotoapi.Presentador.Presentador;
import fabian.arevalo.tokotoapi.R;

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

        pass = getIntent().getExtras();
        presenter = new Presentador(this);

        btnrecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.recibirDatosRecuperar(emailolvidar.getText().toString().trim(),Olvidar.this);
            }
        });


    }
    @Override
    public void mostrarMensaje(String msg) {
    System.out.println("fabian"+msg);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void salirolvidar(View view) {
        onBackPressed();
    }
}