package com.example.a3dskillz.model;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a3dskillz.pojo.Artista;
import com.example.a3dskillz.pojo.Figura;
import com.example.a3dskillz.repository.Repository;

import java.util.List;

public class ViewModelActivity extends AndroidViewModel {

    private Repository repository;

    public ViewModelActivity(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
    }

    public MutableLiveData<List<Artista>> getArtistas() {
        return repository.getArtistas();
    }

    public void deleteArtista(long id, View view) {
        repository.deleteArtista(id, view);
    }

    public void insertArtista(Artista artista, View view) {
        repository.insertArtista(artista, view);
    }

    public void updateArtista(long id, Artista artista, View view) {
        repository.updateArtista(id, artista, view);
    }

    public Artista getCurrentArtista() {
        return repository.getCurrentArtista();
    }

    public void setCurrentArtista(Artista currentArtista) {
        repository.setCurrentArtista(currentArtista);
    }

    public Figura getCurrentFigura() {
        return repository.getCurrentFigura();
    }

    public void setCurrentFigura(Figura currentFigura) {
        repository.setCurrentFigura(currentFigura);
    }

    public MutableLiveData<List<Figura>> getFiguras() {
        return repository.getFiguras();
    }

    public void updateFigura(long id, Figura figura, View view) {
        repository.updateFigura(id, figura, view);
    }

    public void insertFigura(Figura figura, View view) {
        repository.insertFigura(figura, view);
    }

    public void deleteFigura(long id, View view) {
        repository.deleteFigura(id, view);
    }
}
