package fabian.arevalo.tokotoapi.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import fabian.arevalo.tokotoapi.Modelo.ProductoResults;
import fabian.arevalo.tokotoapi.R;
import fabian.arevalo.tokotoapi.Vista.Descripcion;

public class AdaptadorInicio extends RecyclerView.Adapter<AdaptadorInicio.ViewHolder> {

    private ArrayList<ProductoResults> results;
    private Context context;

    public AdaptadorInicio(ArrayList<ProductoResults> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_producto,null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.url= results.get(position).getThumbnail().replaceFirst("http","https");

        Glide.with(context).load(holder.url).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.foto);
        holder.itemView.setOnClickListener(view->{

            Intent intent= new Intent(context, Descripcion.class);
            intent.putExtra("foto", holder.url);
            intent.putExtra("titulo", results.get(position).getTitle());
            intent.putExtra("cantidad", results.get(position).getAvailable_quantity());
            intent.putExtra("precio", results.get(position).getPrice());
            intent.putExtra("caracteristicas",results.get(position).getAttributes());
            context.startActivity(intent);


        });

    }

    @Override
    public int getItemCount() {

        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView foto;
        private String url;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foto= itemView.findViewById(R.id.idimagenproducto);
        }
    }
}
