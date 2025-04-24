package com.example.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailClub extends AppCompatActivity {

    TextView tvNamaClubDetail;
    TextView tvStadionDetail;
    ImageView imgClubDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_club);

        tvNamaClubDetail = findViewById(R.id.tvNamaClubDetail);
        tvStadionDetail = findViewById(R.id.tvStadionDetail);
        imgClubDetail = findViewById(R.id.imgClubDetail);

        Intent intent = getIntent();
        String namaClub = intent.getStringExtra("namaClub");
        String stadion = intent.getStringExtra("stadion");
        String imageUrl = intent.getStringExtra("imageUrl");

        tvNamaClubDetail.setText(namaClub);
        tvStadionDetail.setText(stadion);

        Glide.with(this)
                .load(imageUrl)
                .into(imgClubDetail);
    }
}
