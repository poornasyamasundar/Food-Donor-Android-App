package com.example.phase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = findViewById(R.id.button);
        TextView txt = findViewById(R.id.data);
        Button profileBtn = findViewById(R.id.userProfile);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDonorList();
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProfile();
            }
        });
    }

    public void showProfile()
    {
        Intent intent = new Intent( this , userProfile.class);
        startActivity(intent);
    }

    public void openDonorList()
    {
        Intent intent = new Intent(this, DonorListActivity.class);
        startActivity(intent);
    }
}