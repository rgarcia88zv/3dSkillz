package com.example.a3dskillz.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a3dskillz.R;
import com.example.a3dskillz.model.ViewModelActivity;
import com.example.a3dskillz.pojo.Artista;
import com.example.a3dskillz.pojo.Figura;

import java.util.List;


public class DetailsFragment extends Fragment {

    ViewModelActivity viewModelActivity;

    public DetailsFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);

        TextView tvNombre = view.findViewById(R.id.tvNombreD);
        TextView tvMaterial = view.findViewById(R.id.tvMaterialD);
        TextView tvPrecio = view.findViewById(R.id.tvPrecioD);
        TextView tvArtista = view.findViewById(R.id.tvArtistaD);
        ImageView imgFigura = view.findViewById(R.id.imgDetails);

        Figura f = viewModelActivity.getCurrentFigura();

        tvNombre.setText(f.getNombreFigura());
        tvMaterial.setText("Material: " + f.getMaterialFigura());
        tvPrecio.setText(String.valueOf(f.getPrecioFigura()) + "€");



        viewModelActivity.getArtistas().observe(getActivity(), new Observer<List<Artista>>() {
            @Override
            public void onChanged(List<Artista> artistas) {
                for (int i = 0; i < artistas.size(); i++) {
                    if(artistas.get(i).getId() == f.getIdArtista()){
                        tvArtista.setText("Artista: " + artistas.get(i).getNombreArtista() + " " + artistas.get(i).getApellidoArtista());


                    }
                }
            }
        });


        Glide.with(getActivity()).load(f.getImgFigura()).into(imgFigura);





    }
}