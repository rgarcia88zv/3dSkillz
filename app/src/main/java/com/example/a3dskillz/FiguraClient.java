package com.example.a3dskillz;

import com.example.a3dskillz.pojo.Figura;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FiguraClient {

         /*

     GET            |   figura
     POST           |   figura
     GET            |   figura/{id}
     PUT            |   figura/{id}
     DELETE         |   figura/{id}

     */
     @DELETE("figura/{id}")
     Call<Integer> deleteFigura(@Path("id") long id);

    @GET("figura/{id}")
    Call<Figura> getFigura(@Path("id") long id);

    @GET("figura")
    Call<ArrayList<Figura>> getFiguras();

    @POST("figura")
    Call<Long> postFigura(@Body Figura figura);

    @PUT("figura/{id}")
    Call<Boolean> putFigura(@Path("id") long id, @Body Figura figura);

}
