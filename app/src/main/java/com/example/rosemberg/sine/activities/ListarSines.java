package com.example.rosemberg.sine.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.rosemberg.sine.R;
import com.example.rosemberg.sine.asynctasks.ListarSinesAsyncTask;
import com.example.rosemberg.sine.asynctasks.ListarSinesDetalhados;
import com.example.rosemberg.sine.classes.Sine;
import com.example.rosemberg.sine.classes.SineDetalhado;

import java.util.concurrent.ExecutionException;

public class ListarSines extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_sines);

        ListView lista1 = (ListView) findViewById(R.id.lista1);
        ListarSinesAsyncTask listarSinesAsyncTask = new ListarSinesAsyncTask();

        try {
            final ArrayAdapter<Sine> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listarSinesAsyncTask.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/").get());
            lista1.setAdapter(adapter);
            lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String codPost = adapter.getItem(position).getCodPosto();
                    ListView listView = (ListView) findViewById(R.id.lista1);
                    ListarSinesDetalhados listarSinesDetalhados = new ListarSinesDetalhados();
                    try {
                        ArrayAdapter<SineDetalhado> adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, listarSinesDetalhados.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/cod/" + codPost).get());
                        listView.setAdapter(adapter);
                    } catch (InterruptedException | ExecutionException e) {

                        e.printStackTrace();
                    }
                }
            });
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }



}

