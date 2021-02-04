package com.example.a3dskillz.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.a3dskillz.R;
import com.example.a3dskillz.model.ViewModelActivity;
import com.example.a3dskillz.pojo.Artista;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class CreateArtistFragment extends Fragment {

    private ViewModelActivity viewModelActivity;

    public CreateArtistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_artist, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);

        EditText etUrl, etNombre, etApellido, etEstilo, etTelf;

        Button btGuardar = view.findViewById(R.id.btGuardarArtista);
        etUrl = view.findViewById(R.id.etImageA);
        etNombre = view.findViewById(R.id.etNombreA);
        etApellido = view.findViewById(R.id.etApellidoA);
        etEstilo = view.findViewById(R.id.etEstiloA);
        etTelf = view.findViewById(R.id.etTelfA);

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        String URL= etUrl.getText().toString();
                        String nombre = etNombre.getText().toString();
                        String apellido= etApellido.getText().toString();
                        String estilo= etEstilo.getText().toString();
                        String telf= etTelf.getText().toString();

                Artista a = new Artista(nombre,apellido,estilo,URL,Integer.parseInt(telf));
                viewModelActivity.insertArtista(a,v);
                NavHostFragment.findNavController(CreateArtistFragment.this).popBackStack();
                Snackbar.make(view,"Artista Insertado", BaseTransientBottomBar.LENGTH_SHORT).show();

            }
        });



    }
}