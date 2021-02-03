package com.example.a3dskillz;

import com.example.a3dskillz.pojo.Artista;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ArtistaClient {

       /*

     GET            |   artista
     POST           |   artista
     GET            |   artista/{id}
     PUT            |   artista/{id}
     DELETE         |   artista/{id}

     */

    @DELETE("artista/{id}")
    Call<Integer> deleteArtista(@Path("id") long id);

    @GET("artista/{id}")
    Call<Artista> getArtista(@Path("id") long id);

    @GET("artista")
    Call<ArrayList<Artista>> getArtistas();

    @POST("artista")
    Call<Long> postArtista(@Body Artista artista);

    @PUT("artista/{id}")
    Call<Boolean> putArtista(@Path("id") long id, @Body Artista artista);

}
