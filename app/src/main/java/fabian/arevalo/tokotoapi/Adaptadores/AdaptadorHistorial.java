package fabian.arevalo.tokotoapi.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import fabian.arevalo.tokotoapi.Modelo.ListHistorial;
import fabian.arevalo.tokotoapi.R;

public class AdaptadorHistorial extends RecyclerView.Adapter<AdaptadorHistorial.ViewHolderHistorial> {
    private List<ListHistorial> date;
    private LayoutInflater mInflater;
    private Context context;

    public AdaptadorHistorial(List<ListHistorial> date, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.date = date;
    }

    @NonNull
    @Override
    public ViewHolderHistorial onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_historial, null);
        return new AdaptadorHistorial.ViewHolderHistorial(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderHistorial holder, int position) {
        holder.bindData(date.get(position));


    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    public class ViewHolderHistorial extends RecyclerView.ViewHolder {
        TextView nombreProducto,precio;
        ImageView image;
        String url;

        public ViewHolderHistorial(@NonNull View itemView) {
            super(itemView);
            nombreProducto=itemView.findViewById(R.id.idNombre);
            precio=itemView.findViewById(R.id.idprecio);
            image= itemView.findViewById(R.id.imagenHisto);
        }
        void bindData(final ListHistorial item){
            nombreProducto.setText(item.getNombreProducto());
            precio.setText(item.getPrecio());
            url=item.getImagen();

            Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(image);

        }
    }
}
