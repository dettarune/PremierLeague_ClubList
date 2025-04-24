package com.example.retrofit;

import com.google.gson.annotations.SerializedName;

public class ClubModel {
    @SerializedName("strTeam")
    private String namaClub;

    @SerializedName("strStadium")
    private String stadion;

    @SerializedName("strBadge")
    private String imageUrl;

    public ClubModel(String namaClub, String stadion, String imageUrl) {
        this.namaClub = namaClub;
        this.stadion = stadion;
        this.imageUrl = imageUrl;
    }

    public String getNamaClub() {
        return namaClub;
    }

    public void setNamaClub(String namaClub) {
        this.namaClub = namaClub;
    }

    public String getStadion() {
        return stadion;
    }

    public void setStadion(String stadion) {
        this.stadion = stadion;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
