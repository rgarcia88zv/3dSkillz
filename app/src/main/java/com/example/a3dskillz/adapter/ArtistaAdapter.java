package com.example.a3dskillz.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a3dskillz.R;
import com.example.a3dskillz.model.ViewModelActivity;
import com.example.a3dskillz.pojo.Artista;

import java.util.List;

public class ArtistaAdapter extends RecyclerView.Adapter<ArtistaAdapter.ViewHolder>{

    private Context contexto;
    private List<Artista> artistasList;
    ViewModelActivity viewModelActivity;


    public ArtistaAdapter(Context contexto, List<Artista> artistasList) {
        this.contexto = contexto;
        this.artistasList = artistasList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_artistas,parent,false);

        viewModelActivity = new ViewModelProvider((ViewModelStoreOwner) contexto).get(ViewModelActivity.class);
        ViewHolder holder = new ViewHolder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                holder.tvNombre.setText(artistasList.get(position).getNombreArtista());

                String URL = artistasList.get(position).getImgArtista();

                  Glide.with(contexto).load(URL).into(holder.imgFoto);

                holder.parent_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final NavController navController = Navigation.findNavController(v);
                        navController.navigate(R.id.editArtistFragment);
                        viewModelActivity.setCurrentArtista(artistasList.get(position));

                    }
                });

    }

    @Override
    public int getItemCount() {
        return artistasList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombre;
        ImageView imgFoto;
        ConstraintLayout parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvArtistaR);
            imgFoto = itemView.findViewById(R.id.imgArtistaR);
            parent_layout = itemView.findViewById(R.id.recyclerArtista);
        }
    }
}
