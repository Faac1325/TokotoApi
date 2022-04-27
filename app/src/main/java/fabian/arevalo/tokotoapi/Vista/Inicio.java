package fabian.arevalo.tokotoapi.Vista;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import fabian.arevalo.tokotoapi.Interfaces.Interfaces;
import fabian.arevalo.tokotoapi.Modelo.ProductoResults;
import fabian.arevalo.tokotoapi.Presentador.Presentador;
import fabian.arevalo.tokotoapi.R;

public class  Inicio extends AppCompatActivity implements SearchView.OnQueryTextListener, Interfaces.VistaInicio {
    Button btnatrasinicio;
    androidx.appcompat.widget.SearchView search;
    private Presentador presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        search= findViewById(R.id.search);
        search.setOnQueryTextListener(this);
        btnatrasinicio=findViewById(R.id.btnatrasinicio);
        tvsalir();
        presenter= new Presentador(this);


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


    @Override
    public boolean onQueryTextSubmit(String q) {
        enviarBusqueda(q);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void enviarBusqueda(String q) {
        presenter.recibirBusqueda(q);
        search.clearFocus();
    }

    @Override
    public void mostrarProductos(ArrayList<ProductoResults> productos) {

    }
}