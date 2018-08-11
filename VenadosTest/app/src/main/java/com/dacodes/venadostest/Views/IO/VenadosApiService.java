package com.dacodes.venadostest.Views.IO;

import com.dacodes.venadostest.Views.Models.Players.PlayerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface VenadosApiService {

    @Headers( {"Accept: application/json" })
    @GET("players")
    Call<PlayerResponse> getPlayers();
}
