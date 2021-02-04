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

import com.example.a3dskillz.R;
import com.example.a3dskillz.adapter.ForeignAdapter;
import com.example.a3dskillz.model.ViewModelActivity;
import com.example.a3dskillz.pojo.Artista;
import com.example.a3dskillz.pojo.Figura;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class AddFiguraFragment extends Fragment {
    ViewModelActivity viewModelActivity;

     RecyclerView recyclerView;
    ForeignAdapter adapter;


    public AddFiguraFragment() {
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
        return inflater.inflate(R.layout.fragment_add_figura, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);
        List<Artista> artistas = new ArrayList<>();
       recyclerView = view.findViewById(R.id.recyclerAddArtist);
       adapter = new ForeignAdapter(getContext(),artistas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        EditText etId = view.findViewById(R.id.etIdArtistaF);
        EditText etNombre = view.findViewById(R.id.etNombreF);
        EditText etMaterial = view.findViewById(R.id.etMaterialF);
        EditText etPrecio = view.findViewById(R.id.etPrecioF);
        EditText etUrl = view.findViewById(R.id.etURLF);





    viewModelActivity.getArtistas().observe(getActivity(), new Observer<List<Artista>>() {
        @Override
        public void onChanged(List<Artista> artistasList) {

            artistas.clear();
            artistas.addAll(artistasList);
            adapter.notifyDataSetChanged();
        }
    });



        Button btGuardar = view.findViewById(R.id.btAgregarFigura);

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    Long idArtista = Long.parseLong(etId.getText().toString());
                    String nombre = etNombre.getText().toString();
                    String material = etMaterial.getText().toString();
                    String url = etUrl.getText().toString();
                    double precio = Float.parseFloat(etPrecio.getText().toString());




                    Figura f = new Figura(idArtista,nombre,material,url,precio);

                    viewModelActivity.insertFigura(f,v);
                    Snackbar.make(v,"Figura insertada", BaseTransientBottomBar.LENGTH_SHORT).show();
                NavHostFragment.findNavController(AddFiguraFragment.this).popBackStack();





            }
        });


    }


}