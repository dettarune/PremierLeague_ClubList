package com.example.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {
    Button btnPremiereLeague;
    Button btnSpainLeague;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);

        btnPremiereLeague = (Button) findViewById(R.id.btnPremiereLeague);
        btnSpainLeague = (Button) findViewById(R.id.btnSpainLeague);

        btnPremiereLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PremiereLeaguePage = new Intent(MainMenu.this, PremiereLeague.class);
                startActivity(PremiereLeaguePage);
            }
        });

        btnSpainLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SpainLeaguePage = new Intent(MainMenu.this, SpainLeague.class);
                startActivity(SpainLeaguePage);
            }
        });




    }
}