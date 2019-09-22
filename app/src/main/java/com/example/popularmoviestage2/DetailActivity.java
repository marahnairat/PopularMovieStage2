package com.example.popularmoviestage2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity implements DetailFragment.OnFragmentInteractionListener{

    Integer id;

    String LOG_TAG = "DetailActivity";

    Boolean restored = Boolean.FALSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        id = intent.getIntExtra("Movie ID", 0);

        if(!restored) {
            DetailFragment detailFragment = new DetailFragment();
            Bundle arguments = new Bundle();
            arguments.putBoolean("twoPane", Boolean.FALSE);
            arguments.putInt("MovieId", id);
            detailFragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.movie_detail_container, detailFragment)
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        restored = Boolean.TRUE;
    }
}
