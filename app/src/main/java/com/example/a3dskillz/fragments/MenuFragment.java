package com.example.a3dskillz.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a3dskillz.R;


public class MenuFragment extends Fragment {



    Button btFiguras;
    Button btVistaCliente;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btArtistas = view.findViewById(R.id.btArtistas);
        Button btFiguras = view.findViewById(R.id.btFiguras);
        Button btTienda = view.findViewById(R.id.btCliente);

        final NavController navController = Navigation.findNavController(view);

        btArtistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               navController.navigate(R.id.action_menuFragment_to_artistasFragment2);
            }
        });

        btFiguras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_menuFragment_to_figurasFragment);
            }
        });

        btTienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.clienteFragment);
            }
        });



    }
}