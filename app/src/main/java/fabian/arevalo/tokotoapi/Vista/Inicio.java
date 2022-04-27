package fabian.arevalo.tokotoapi.Vista;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

import fabian.arevalo.tokotoapi.Interfaces.Interfaces;
import fabian.arevalo.tokotoapi.Modelo.ProductoResults;
import fabian.arevalo.tokotoapi.Presentador.Presentador;
import fabian.arevalo.tokotoapi.R;

public class  Inicio extends AppCompatActivity implements SearchView.OnQueryTextListener, Interfaces.VistaInicio {
    Button btnatrasinicio;
    ImageButton btnoferta,btnfactura,btnjuegos,btnregalo,btnmas,btnnotificacion,btnhome,btnfavorito,btnmensaje,btnusuario;
    androidx.appcompat.widget.SearchView search;

    private Presentador presenter;

    String url_oferta = "https://www.mercadolibre.com.co/ofertas?promotion_type=lightning&container_id=MCO779366-1#origin=scut&filter_applied=promotion_type&filter_position=2&is_recommended_domain=false";
    String url_factura = "https://myaccount.mercadolibre.com.co/billing/summary";
    String url_juegos = "https://www.mercadolibre.com.co/c/consolas-y-videojuegos#menu=categories";
    String url_regalo = "https://www.mercadolibre.com.co/ofertas#nav-header";
    String url_mas = "https://www.mercadolibre.com.co/categorias";
    String url_notficacion = "https://www.mercadolibre.com.co/gz/notifications/settings";

    String url_home = "https://www.mercadolibre.com.co";
    String url_favorito = "https://myaccount.mercadolibre.com.co/bookmarks/list";
    String url_mensaje = "https://www.mercadolibre.com.co/preguntas/comprador";
    String url_usuario = "https://www.mercadolibre.com.co/hub-engine/hubs/my-profile#menu-user";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        search= findViewById(R.id.search);
        search.setOnQueryTextListener(this);

        btnatrasinicio=findViewById(R.id.btnatrasinicio);
        btnoferta= findViewById(R.id.btnoferta);
        btnfactura=findViewById(R.id.btnfactura);
        btnjuegos=findViewById(R.id.btnjuegos);
        btnregalo=findViewById(R.id.btnregalo);
        btnmas=findViewById(R.id.btnmas);
        btnnotificacion=findViewById(R.id.btnnotificacion);
        btnhome=findViewById(R.id.btnhome);
        btnfavorito=findViewById(R.id.btnfavorito);
        btnmensaje=findViewById(R.id.btnmensaje);
        btnusuario=findViewById(R.id.btnusuario);




        tvsalir();
        presenter= new Presentador(this);

        btnoferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri urlg = Uri.parse(url_oferta);
                Intent i3 = new Intent(Intent.ACTION_VIEW, urlg);
                startActivity(i3);
            }
        });
        btnfactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri urlg = Uri.parse(url_factura);
                Intent i3 = new Intent(Intent.ACTION_VIEW, urlg);
                startActivity(i3);
            }
        });
        btnjuegos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri urlg = Uri.parse(url_juegos);
                Intent i3 = new Intent(Intent.ACTION_VIEW, urlg);
                startActivity(i3);
            }
        });
        btnregalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri urlg = Uri.parse(url_regalo);
                Intent i3 = new Intent(Intent.ACTION_VIEW, urlg);
                startActivity(i3);
            }
        });
        btnmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri urlg = Uri.parse(url_mas);
                Intent i3 = new Intent(Intent.ACTION_VIEW, urlg);
                startActivity(i3);
            }
        });
        btnnotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri urlg = Uri.parse(url_notficacion);
                Intent i3 = new Intent(Intent.ACTION_VIEW, urlg);
                startActivity(i3);
            }
        });

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri urlg = Uri.parse(url_home);
                Intent i3 = new Intent(Intent.ACTION_VIEW, urlg);
                startActivity(i3);
            }
        });
        btnfavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri urlg = Uri.parse(url_favorito);
                Intent i3 = new Intent(Intent.ACTION_VIEW, urlg);
                startActivity(i3);
            }
        });
        btnmensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri urlg = Uri.parse(url_mensaje);
                Intent i3 = new Intent(Intent.ACTION_VIEW, urlg);
                startActivity(i3);
            }
        });

        btnusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri urlg = Uri.parse(url_usuario);
                Intent i3 = new Intent(Intent.ACTION_VIEW, urlg);
                startActivity(i3);
            }
        });

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