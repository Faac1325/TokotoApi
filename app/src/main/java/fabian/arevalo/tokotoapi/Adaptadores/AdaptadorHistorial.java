package fabian.arevalo.tokotoapi.Adaptadores;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorHistorial extends RecyclerView.Adapter<AdaptadorHistorial.ViewHolderHistorial> {


    @NonNull
    @Override
    public ViewHolderHistorial onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderHistorial holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderHistorial extends RecyclerView.ViewHolder {
        public ViewHolderHistorial(@NonNull View itemView) {
            super(itemView);
        }
    }
}
