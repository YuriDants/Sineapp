package com.example.rosemberg.sine.asynctasks;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.rosemberg.sine.classes.Sine;
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
        List<SineDetalhado> sineDetalhados = new ArrayList<>();

        try{
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type","application/json");
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));

            sineDetalhados = getSines(jsonReader);

            inputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            Log.e("Erro","Ero ao conectar a internet", ex);
        }
        return sineDetalhados;
    }
    public  List<SineDetalhado> getSines(JsonReader jsonReader) throws IOException{
        List<SineDetalhado> sineDetalhadoList = new ArrayList<SineDetalhado>();
        jsonReader.beginArray();

        while (jsonReader.hasNext()){
            sineDetalhadoList.add(getSine(jsonReader));
        }
        jsonReader.endArray();
        return sineDetalhadoList;
    }
    public SineDetalhado getSine(JsonReader jsonReader) throws IOException{
        String codPosto="",nome = "",entidadeConveniada = "",endereco="",bairro="",cep="",telefone="",municipio="",uf="",lat="",lon="";
        jsonReader.beginObject();

        while (jsonReader.hasNext()) {
            String obj = jsonReader.nextName();
            if (obj.equals("codPosto")) {
                codPosto = jsonReader.nextString();
            }else if (obj.equals("nome")) {
                nome = jsonReader.nextString();
            }else if (obj.equals("entidadeConveniada")) {
                entidadeConveniada = jsonReader.nextString();
            }else if (obj.equals("endereco")){
                endereco = jsonReader.nextString();
            }else if (obj.equals("bairro")) {
                bairro = jsonReader.nextString();
            }else if (obj.equals("cep")){
                cep = jsonReader.nextString();
            }else if (obj.equals("telefone")){
                telefone = jsonReader.nextString();
            }else if (obj.equals("municipio")){
                municipio = jsonReader.nextString();
            }else if (obj.equals("uf")){
                uf = jsonReader.nextString();
            }else if (obj.equals("lat")){
                lat = jsonReader.nextString();
            }else if (obj.equals("long")){
                lon = jsonReader.nextString();
            }else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return  new SineDetalhado(codPosto, nome, entidadeConveniada, endereco, bairro, cep, telefone, municipio, uf, lat, lon);
    }
    protected  void onPostExecute(List<SineDetalhado> result){
        super.onPostExecute(result);
    }


}
