package com.example.a3dskillz.repository;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a3dskillz.ArtistaClient;
import com.example.a3dskillz.FiguraClient;
import com.example.a3dskillz.pojo.Artista;
import com.example.a3dskillz.pojo.Figura;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    ArtistaClient artistaClient;
    FiguraClient figuraClient;

    Retrofit retrofit;

    private Artista currentArtista;
    private Figura currentFigura;

    public Artista getCurrentArtista() {
        return currentArtista;
    }

    public void setCurrentArtista(Artista currentArtista) {
        this.currentArtista = currentArtista;
    }

    public Figura getCurrentFigura() {
        return currentFigura;
    }

    public void setCurrentFigura(Figura currentFigura) {
        this.currentFigura = currentFigura;
    }

    private LiveData<List<Artista>> liveArtistaInsertId = new MutableLiveData<>();

    private LiveData<List<Figura>> liveFiguraList;
    private LiveData<List<Figura>> liveFiguraInsertId = new MutableLiveData<>();

    private List<Artista> artistasList = new ArrayList<>();
    private List<Figura> figurasList = new ArrayList<>();

    public Repository(Context context) {
        String Url = "https://informatica.ieszaidinvergeles.org:9025/Laravel/3dprintingapp/3dprintingapp/public/api/";
         retrofit = new Retrofit.Builder().baseUrl(Url).addConverterFactory(GsonConverterFactory.create()).build();


    }

    public MutableLiveData<List<Artista>> getArtistas(){
        MutableLiveData<List<Artista>> liveArtistaList = new MutableLiveData<>();
        artistaClient = retrofit.create(ArtistaClient.class);
        Call<ArrayList<Artista>> call = artistaClient.getArtistas();

        call.enqueue(new Callback<ArrayList<Artista>>(){
            @Override
            public void onResponse(Call<ArrayList<Artista>> call, Response<ArrayList<Artista>> response) {
                liveArtistaList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Artista>> call, Throwable t) {
                    Log.v("xyzyx","Fallo: " + t.getMessage());
            }
        });
        return  liveArtistaList;
    }

    public void deleteArtista(long id, View view){

        artistaClient = retrofit.create(ArtistaClient.class);
        Call<Integer> call = artistaClient.deleteArtista(id);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {

            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });

    }

    public void insertArtista(Artista artista, View view){
        artistaClient = retrofit.create(ArtistaClient.class);
        Call<Long> call = artistaClient.postArtista(artista);
        call.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {


            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {


            }
        });

    }

    public void updateArtista(long id,Artista artista, View view){
        artistaClient = retrofit.create(ArtistaClient.class);
        Call<Boolean> call = artistaClient.putArtista(id,artista);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });


    }

    public MutableLiveData<List<Figura>> getFiguras(){
        MutableLiveData<List<Figura>> liveFigureList = new MutableLiveData<>();
        figuraClient = retrofit.create(FiguraClient.class);
        Call<ArrayList<Figura>> call = figuraClient.getFiguras();

        call.enqueue(new Callback<ArrayList<Figura>>(){


            @Override
            public void onResponse(Call<ArrayList<Figura>> call, Response<ArrayList<Figura>> response) {
                liveFigureList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Figura>> call, Throwable t) {
                Log.v("xyzyx","Fallo: " + t.getMessage());
            }
        });
        return  liveFigureList;
    }

    public void updateFigura(long id,Figura figura, View view){
        figuraClient = retrofit.create(FiguraClient.class);
        Call<Boolean> call = figuraClient.putFigura(id,figura);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });


    }

    public void insertFigura(Figura figura, View view){
        figuraClient = retrofit.create(FiguraClient.class);
        Call<Long> call = figuraClient.postFigura(figura);
        call.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {


            }

            @Override
            public void onFailure(Call<Long> call, Throwable t) {


            }
        });

    }


    public void deleteFigura(long id, View view){

        figuraClient = retrofit.create(FiguraClient.class);
        Call<Integer> call = figuraClient.deleteFigura(id);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {

            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });

    }




}
