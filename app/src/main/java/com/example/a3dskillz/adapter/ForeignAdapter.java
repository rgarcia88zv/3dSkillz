package com.example.a3dskillz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3dskillz.R;
import com.example.a3dskillz.pojo.Artista;

import java.util.List;

public class ForeignAdapter  extends RecyclerView.Adapter<ForeignAdapter.ViewHolder>{

    private Context contexto;
    private List<Artista> artistasList;

    public ForeignAdapter(Context contexto, List<Artista> artistasList) {
        this.contexto = contexto;
        this.artistasList = artistasList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_figuras_artistas,parent,false);
        ViewHolder holder = new ViewHolder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNombre.setText(artistasList.get(position).getNombreArtista());
        holder.tvId.setText(String.valueOf(artistasList.get(position).getId()));

    }

    @Override
    public int getItemCount() {
        return artistasList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvId;
        TextView tvNombre;
        ConstraintLayout parent_layout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvArtistaN);
           tvId = itemView.findViewById(R.id.tvId);
            parent_layout = itemView.findViewById(R.id.recycler_foraneo);
        }
    }
}
