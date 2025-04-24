package com.example.retrofit;

import java.util.List;

public class ClubResponse {
    private List<ClubModel> teams;

    public List<ClubModel> getTeams() {
        return teams;
    }

    public void setTeams(List<ClubModel> teams) {
        this.teams = teams;
    }
}
