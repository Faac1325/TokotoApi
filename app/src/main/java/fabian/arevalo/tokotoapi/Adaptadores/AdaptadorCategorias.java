package fabian.arevalo.tokotoapi.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fabian.arevalo.tokotoapi.Modelo.Category;
import fabian.arevalo.tokotoapi.Modelo.ProductoResults;
import fabian.arevalo.tokotoapi.R;

public class AdaptadorCategorias extends RecyclerView.Adapter<AdaptadorCategorias.ViewHolderCategoria> {


    private List<Category> results;
    private Context context;

    public AdaptadorCategorias(List<Category> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderCategoria onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_categoria,null,false);
        return new ViewHolderCategoria(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCategoria holder, int position) {

        holder.nameCategoria.setText(results.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolderCategoria extends RecyclerView.ViewHolder {
        private TextView nameCategoria;

        public ViewHolderCategoria(@NonNull View itemView) {
            super(itemView);
            nameCategoria= itemView.findViewById(R.id.categoria);

        }
    }
}
