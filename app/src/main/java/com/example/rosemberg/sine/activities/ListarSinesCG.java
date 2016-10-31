package com.example.rosemberg.sine.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.rosemberg.sine.R;
import com.example.rosemberg.sine.classes.Sine;

import java.util.concurrent.ExecutionException;

public class ListarSinesCG extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_sines_campina);

        ListView listView = (ListView) findViewById(R.id.lista1);
        ListarSines listarSines = new ListarSines();

        try {
            ArrayAdapter<Sine> adapter = new ArrayAdapter<Sine>(this,android.R.layout.simple_list_item_1, listarSines.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/latitude/-7.242662/longitude/-35.9716057/raio/100").get());
            listView.setAdapter(adapter);
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        }



    }


