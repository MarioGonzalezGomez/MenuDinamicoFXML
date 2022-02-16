package mggcode.menudinamico.rest;


import mggcode.menudinamico.entity.Persona;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface AccesoDatosRest {

    @GET("users")
    Call<List<Persona>> personasGetAll();

    @GET("users/{id}")
    Call<Persona> personaGetById(@Path("id") String id);

}

