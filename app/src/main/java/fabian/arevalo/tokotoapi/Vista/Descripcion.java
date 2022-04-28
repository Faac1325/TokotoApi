package fabian.arevalo.tokotoapi.Vista;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import fabian.arevalo.tokotoapi.Adaptadores.AdapterDescripcion;
import fabian.arevalo.tokotoapi.Modelo.ProductoAttributes;
import fabian.arevalo.tokotoapi.R;


public class Descripcion extends AppCompatActivity {

    private Bundle bundle;
    private RecyclerView recyclerDescripcion;
    private AdapterDescripcion adaptadorDescripcionProducto;

    private TextView titulo, precio;
    private ImageView imagen, atras;
    ArrayList<ProductoAttributes> attributes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        bundle = getIntent().getExtras();
        recyclerDescripcion= findViewById(R.id.rvdescripcion);
        titulo= findViewById(R.id.titulo);
        precio= findViewById(R.id.precio);
        imagen= findViewById(R.id.imagen);
        atras= findViewById(R.id.atras);
        attributes=(ArrayList<ProductoAttributes>)bundle.getSerializable("caracteristicas");
        recyclerDescripcion.setLayoutManager(new LinearLayoutManager(this));
        AdapterDescripcion adapter= new AdapterDescripcion(attributes,this);
        recyclerDescripcion.setAdapter(adapter);

        imagen.setImageResource(bundle.getInt("foto"));
        String imagenObtenida=bundle.getString("foto");
        Glide.with(this).load(imagenObtenida).centerCrop().circleCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(imagen);
        titulo.setText(bundle.getString("titulo"));
        precio.setText(bundle.getString("precio"));

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

   }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}