package com.example.rosemberg.sine.listeners;

import android.content.Intent;
import android.view.View;

import com.example.rosemberg.sine.activities.ListarSinesCG;
import com.example.rosemberg.sine.activities.MainActivity;

/**
 * Created by yurid on 30/10/2016.
 */
public class ListarSinesCGOnClickListener implements View.OnClickListener {
    private MainActivity mainActivity;

    public ListarSinesCGOnClickListener(MainActivity mainActivity) {this.mainActivity = mainActivity;}

    public void onClick(View view) {
        Intent intent = new Intent(mainActivity, ListarSinesCG.class);
        mainActivity.startActivity(intent);
    }
}
