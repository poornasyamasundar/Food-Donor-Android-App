
package com.example.phase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

// This function is used to manipulate the donorlist viewing page of the app.
public class DonorListActivity extends AppCompatActivity {

    private RecyclerView donorlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_list);

        donorlist = findViewById(R.id.DonorListRecView);

        DonorListRecViewAdapter adapter = new DonorListRecViewAdapter();
        adapter.setList(DonorClass.getAllDonors());

        donorlist.setAdapter(adapter);
        donorlist.setLayoutManager(new LinearLayoutManager(this));
    }
}