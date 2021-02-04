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
import android.widget.ImageView;

import com.example.a3dskillz.R;
import com.example.a3dskillz.model.ViewModelActivity;
import com.example.a3dskillz.pojo.Artista;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;


public class EditArtistFragment extends Fragment {

        ViewModelActivity viewModelActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_artist, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);

        EditText etUrl, etNombre, etApellido, etEstilo, etTelf;

        etUrl = view.findViewById(R.id.etImageA);
        etNombre = view.findViewById(R.id.etNombreA);
        etApellido = view.findViewById(R.id.etApellidoA);
        etEstilo = view.findViewById(R.id.etEstiloA);
        etTelf = view.findViewById(R.id.etTelfA);

        Artista a = viewModelActivity.getCurrentArtista();
        etUrl.setText(a.getImgArtista());
        etNombre.setText(a.getNombreArtista());
        etApellido.setText(a.getApellidoArtista());
        etEstilo.setText(a.getEstiloArtista());
        etTelf.setText((String.valueOf(a.getTelfArtista())));

        Button btEditar = view.findViewById(R.id.btActualizarArtista);


        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String URL= etUrl.getText().toString();
                String nombre = etNombre.getText().toString();
                String apellido= etApellido.getText().toString();
                String estilo= etEstilo.getText().toString();
                String telf= etTelf.getText().toString();

                Artista artista = new Artista(nombre,apellido,estilo,URL,Integer.parseInt(telf));
                viewModelActivity.updateArtista(a.getId(),artista,v);
                NavHostFragment.findNavController(EditArtistFragment.this).popBackStack();
                Snackbar.make(view,"Artista actualizado", BaseTransientBottomBar.LENGTH_SHORT).show();

            }
        });
        ImageView borrar = view.findViewById(R.id.btBorrar);
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelActivity.deleteArtista(a.getId(),v);
                NavHostFragment.findNavController(EditArtistFragment.this).popBackStack();
                Snackbar.make(view,"Artista eliminado", BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });
    }
}