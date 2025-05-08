package com.example.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServicePremiere {
    @GET("/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League")
    Call<ClubResponse> getAllTeams();
}
