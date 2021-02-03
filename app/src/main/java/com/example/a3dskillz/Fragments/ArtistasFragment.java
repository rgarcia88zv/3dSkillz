package com.example.a3dskillz.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3dskillz.R;

import com.example.a3dskillz.adapter.ArtistaAdapter;
import com.example.a3dskillz.model.ViewModelActivity;
import com.example.a3dskillz.pojo.Artista;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ArtistasFragment extends Fragment {
    ViewModelActivity viewModelActivity;
    private List<Artista> artistas = new ArrayList<>();

    private RecyclerView recyclerView;
    private ArtistaAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artistas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);
        final NavController navController = Navigation.findNavController(view);
        FloatingActionButton btAdd = view.findViewById(R.id.btaddArtist);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.createArtistFragment);
            }
        });

        recyclerView = view.findViewById(R.id.recyclerArtistasF);
        adapter = new ArtistaAdapter(getContext(),artistas);
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

    }
}