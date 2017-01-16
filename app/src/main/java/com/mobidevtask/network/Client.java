package com.mobidevtask.network;


import com.mobidevtask.network.pojo.PokemonsResponse;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface Client {

    @GET("pokemon/")
    Observable<PokemonsResponse> loadPokemonsList(@QueryMap Map<String, String> filter);

    @GET("pokemon/{id}")
    Observable<Object> loadPokemonById(@Path("id") long id);
}
