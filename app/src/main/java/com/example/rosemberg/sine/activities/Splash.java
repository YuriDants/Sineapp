package com.example.rosemberg.sine.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rosemberg.sine.R;

public class Splash extends Activity {

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IniciaSplash();
    }

    public void IniciaSplash(){
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {
                counter++;

                try{
                    while(counter == 1 || counter <= 5){
                        Thread.sleep(1000);
                        counter++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(counter == 6){
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);

                    counter++;
                }
            }
        }).start();
    }
}
