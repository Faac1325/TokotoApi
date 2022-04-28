package fabian.arevalo.tokotoapi.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fabian.arevalo.tokotoapi.Modelo.ProductoAttributes;
import fabian.arevalo.tokotoapi.R;

public class AdapterDescripcion extends RecyclerView.Adapter<AdapterDescripcion.ViewHolderDescripcion> {
    private ArrayList<ProductoAttributes> attributes;
    private Context context;

    public AdapterDescripcion(ArrayList<ProductoAttributes> attributes, Context context) {
        this.attributes = attributes;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderDescripcion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_descripcion_producto, null, false);
        return new ViewHolderDescripcion(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDescripcion holder, int position) {
        holder.informacion1.setText(attributes.get(position).getName());
        holder.informacion2.setText(attributes.get(position).getValue_name());

    }

    @Override
    public int getItemCount() {
        return attributes.size();
    }

    public class ViewHolderDescripcion extends RecyclerView.ViewHolder {
        private TextView informacion1, informacion2;

        public ViewHolderDescripcion(@NonNull View itemView) {
            super(itemView);
            informacion1= itemView.findViewById(R.id.info1);
            informacion2= itemView.findViewById(R.id.info2);
        }
    }
}
