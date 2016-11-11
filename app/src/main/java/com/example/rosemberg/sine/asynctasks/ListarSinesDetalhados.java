package com.example.rosemberg.sine.asynctasks;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import com.example.rosemberg.sine.classes.SineDetalhado;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListarSinesDetalhados extends AsyncTask< String, Void, List<SineDetalhado>> {

    protected List<SineDetalhado> doInBackground(String... strings) {
        String urlString = strings[0];
        List<SineDetalhado> sine = new ArrayList<>();

        try{
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type","application/json");
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));

            sine = getSines(reader);

            inputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            Log.e("Erro","Ero ao conectar a internet", ex);
        }
        return sine;
    }
    public  List<SineDetalhado> getSines(JsonReader reader) throws IOException{
        List<SineDetalhado> sines = new ArrayList<>();
        reader.beginArray();

        while (reader.hasNext()){
            sines.add(getSine(reader));
        }
        reader.endArray();
        return sines;
    }
    public SineDetalhado getSine(JsonReader reader) throws IOException{
        String codPosto="",nome = "",entidadeConveniada = "",endereco="",bairro="",cep="",telefone="",municipio="",uf="",lat="",lon="";
        reader.beginObject();

        while (reader.hasNext()) {
            String obj = reader.nextName();
            if (obj.equals("codPosto")) {
                codPosto = reader.nextString();
            }else if (obj.equals("nome")) {
                nome = reader.nextString();
            }else if (obj.equals("entidadeConveniada")) {
                entidadeConveniada = reader.nextString();
            }else if (obj.equals("endereco")){
                endereco = reader.nextString();
            }else if (obj.equals("bairro")) {
                bairro = reader.nextString();
            }else if (obj.equals("cep")){
                cep = reader.nextString();
            }else if (obj.equals("telefone")){
                telefone = reader.nextString();
            }else if (obj.equals("municipio")){
                municipio = reader.nextString();
            }else if (obj.equals("uf")){
                uf = reader.nextString();
            }else if (obj.equals("lat")){
                lat = reader.nextString();
            }else if (obj.equals("long")){
                lon = reader.nextString();
            }else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return  new SineDetalhado(codPosto, nome, entidadeConveniada, endereco, bairro, cep, telefone, municipio, uf, lat, lon);
    }
    protected  void onPostExecute(List<SineDetalhado> result){
        super.onPostExecute(result);
    }


}
