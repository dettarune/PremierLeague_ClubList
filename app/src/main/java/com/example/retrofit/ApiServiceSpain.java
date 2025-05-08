package com.example.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServiceSpain {
    @GET("/api/v1/json/3/search_all_teams.php?s=Soccer&c=Spain")
    Call<ClubResponse> getAllTeams();
}

// push ulang, lupa kasih nama feat, malah fix tadi