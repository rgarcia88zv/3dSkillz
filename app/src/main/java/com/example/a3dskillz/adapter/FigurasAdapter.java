package com.example.a3dskillz.adapter;

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
import com.example.a3dskillz.pojo.Figura;

import java.util.List;

public class FigurasAdapter extends RecyclerView.Adapter<com.example.a3dskillz.adapter.FigurasAdapter.ViewHolder>{
 private Context contexto;
        private List<Figura> figurasList;
        ViewModelActivity viewModelActivity;

    public FigurasAdapter(Context contexto, List<Figura> figurasList) {
        this.contexto = contexto;
        this.figurasList = figurasList;
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
        holder.tvNombre.setText(figurasList.get(position).getNombreFigura());

        String URL = figurasList.get(position).getImgFigura();

        Glide.with(contexto).load(URL).into(holder.imgFoto);

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.editarFigureFragment);
                viewModelActivity.setCurrentFigura(figurasList.get(position));

            }
        });
    }

    @Override
    public int getItemCount() {
        return figurasList.size();
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
