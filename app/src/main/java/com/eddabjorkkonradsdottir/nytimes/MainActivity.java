package com.eddabjorkkonradsdottir.nytimes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import logic.TopStoriesHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new TopStoriesHandler(this);
    }
}