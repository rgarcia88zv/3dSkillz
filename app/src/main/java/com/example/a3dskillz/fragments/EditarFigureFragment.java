package com.example.a3dskillz.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.a3dskillz.R;
import com.example.a3dskillz.adapter.ForeignAdapter;
import com.example.a3dskillz.model.ViewModelActivity;
import com.example.a3dskillz.pojo.Artista;
import com.example.a3dskillz.pojo.Figura;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class EditarFigureFragment extends Fragment {

    ViewModelActivity viewModelActivity;
    private List<Artista> artistas = new ArrayList<>();
    private RecyclerView recyclerView;
    private ForeignAdapter adapter;


    public EditarFigureFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_editar_figure, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);

        EditText etId = view.findViewById(R.id.etIdArtistaF);
        EditText etNombre = view.findViewById(R.id.etNombreF);
        EditText etMaterial = view.findViewById(R.id.etMaterialF);
        EditText etPrecio = view.findViewById(R.id.etPrecioF);
        EditText etUrl = view.findViewById(R.id.etURLF);

        etId.setText(String.valueOf(viewModelActivity.getCurrentFigura().getIdArtista()));
        etNombre.setText(viewModelActivity.getCurrentFigura().getNombreFigura());
        etMaterial.setText(viewModelActivity.getCurrentFigura().getMaterialFigura());
        etUrl.setText(viewModelActivity.getCurrentFigura().getImgFigura());
        etPrecio.setText(String.valueOf(viewModelActivity.getCurrentFigura().getPrecioFigura()));

        recyclerView = view.findViewById(R.id.recyclerAddArtist);
        adapter = new ForeignAdapter(getContext(),artistas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        viewModelActivity.getArtistas().observe(getActivity(), new Observer<List<Artista>>() {
            @Override
            public void onChanged(List<Artista> artistasList) {
                artistas.clear();
                artistas.addAll(artistasList);
                adapter.notifyDataSetChanged();
            }
        });





        ImageView borrar = view.findViewById(R.id.btBorrarFig);
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelActivity.deleteFigura(viewModelActivity.getCurrentFigura().getId(),v);
                Snackbar.make(v,"Figura eliminada", BaseTransientBottomBar.LENGTH_SHORT).show();
                NavHostFragment.findNavController(EditarFigureFragment.this).popBackStack();

            }
        });

        Button btEditar = view.findViewById(R.id.btEditarFigura);
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long idArtista = Long.parseLong(etId.getText().toString());
                String nombre = etNombre.getText().toString();
                String material = etMaterial.getText().toString();
                String url = etUrl.getText().toString();
                double precio = Float.parseFloat(etPrecio.getText().toString());

                Figura f = new Figura(idArtista,nombre,material,url,precio);

                viewModelActivity.updateFigura(viewModelActivity.getCurrentFigura().getId(),f,v);

                Snackbar.make(v,"Figura editada", BaseTransientBottomBar.LENGTH_SHORT).show();
                NavHostFragment.findNavController(EditarFigureFragment.this).popBackStack();

            }
        });
    }
}