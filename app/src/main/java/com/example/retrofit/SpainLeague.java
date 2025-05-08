package com.example.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SpainLeague extends AppCompatActivity implements AdapterListClub.OnItemClickListener {

    RecyclerView rvListClub;
    AdapterListClub adapterListClub;
    ArrayList<ClubModel> dataClub = new ArrayList<>();
    ProgressBar pbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rvListClub = findViewById(R.id.rvListClub);
        pbLoading = findViewById(R.id.pbLoading);

        setupRecyclerView();
        fetchDataClub();
    }

    private void setupRecyclerView() {
        rvListClub.setLayoutManager(new LinearLayoutManager(this));
    }

    private void fetchDataClub() {
        pbLoading.setVisibility(View.VISIBLE);
        rvListClub.setVisibility(View.GONE);

        ApiServiceSpain apiService = ApiClient.getClient().create(ApiServiceSpain.class);
        Call<ClubResponse> call = apiService.getAllTeams();

        call.enqueue(new Callback<ClubResponse>() {
            @Override
            public void onResponse(Call<ClubResponse> call, Response<ClubResponse> response) {
                pbLoading.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    dataClub = new ArrayList<>(response.body().getTeams());
                    adapterListClub = new AdapterListClub(dataClub, SpainLeague.this);
                    rvListClub.setAdapter(adapterListClub);
                    rvListClub.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(SpainLeague.this, "Failed to load data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ClubResponse> call, Throwable t) {
                pbLoading.setVisibility(View.GONE);
                Toast.makeText(SpainLeague.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(ClubModel clubModel) {
        Toast.makeText(this, clubModel.getNamaClub() + " - " + clubModel.getStadion(), Toast.LENGTH_SHORT).show();

        Intent in = new Intent(SpainLeague.this, DetailClub.class);
        in.putExtra("namaClub", clubModel.getNamaClub());
        in.putExtra("stadion", clubModel.getStadion());
        in.putExtra("imageUrl", clubModel.getImageUrl());
        startActivity(in);
    }


}
