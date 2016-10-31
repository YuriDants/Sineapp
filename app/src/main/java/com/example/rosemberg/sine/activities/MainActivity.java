package com.example.rosemberg.sine.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;


import com.example.rosemberg.sine.R;
import com.example.rosemberg.sine.listeners.ListarSinesCGOnClickListener;
import com.example.rosemberg.sine.listeners.ListarSinesOnClickListener;

public class MainActivity extends Activity {
    private Button bSines;
    private Button bSinesCG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bSines = (Button) findViewById(R.id.bSines);
        bSinesCG = (Button) findViewById(R.id.bSinesCG);

        bSines.setOnClickListener(new ListarSinesOnClickListener(this));
        bSinesCG.setOnClickListener(new ListarSinesCGOnClickListener(this));
    }

}
