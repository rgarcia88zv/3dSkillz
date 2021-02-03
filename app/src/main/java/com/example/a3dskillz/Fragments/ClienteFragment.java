package com.example.a3dskillz.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3dskillz.R;
import com.example.a3dskillz.adapter.ClienteAdapter;
import com.example.a3dskillz.adapter.FigurasAdapter;
import com.example.a3dskillz.model.ViewModelActivity;
import com.example.a3dskillz.pojo.Figura;

import java.util.ArrayList;
import java.util.List;


public class ClienteFragment extends Fragment {
    ViewModelActivity viewModelActivity;
    private List<Figura> figuras = new ArrayList<>();

    private RecyclerView recyclerView;
    private ClienteAdapter adapter;

    public ClienteFragment() {
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
        return inflater.inflate(R.layout.fragment_cliente, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);
        final NavController navController = Navigation.findNavController(view);

        recyclerView = view.findViewById(R.id.recyclerTienda);
        adapter = new ClienteAdapter(getContext(),figuras);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        viewModelActivity.getFiguras().observe(getActivity(), new Observer<List<Figura>>() {
            @Override
            public void onChanged(List<Figura> figurasList) {
                figuras.clear();
                figuras.addAll(figurasList);
                adapter.notifyDataSetChanged();
            }
        });
    }
}