package com.example.rosemberg.sine.asynctasks;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import com.example.rosemberg.sine.classes.Sine;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListarSinesAsyncTask extends AsyncTask<String, Void, List<Sine>>{
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Sine> doInBackground(String... strings){
        String urlString = strings[0];
        List<Sine> sines = new ArrayList<>();

        try {
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type","application/json");
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));

            sines= get(jsonReader);
            inputStream.close();

        }   catch (IOException ex) {
            ex.printStackTrace();
            Log.e("Erro","Erro ao conectar a internet", ex);
        } finally {
            return  sines;
        }
    }



    public List<Sine> getSines(JsonReader jsonReader) throws IOException {
        List<Sine> sineList = new ArrayList<Sine>();
        jsonReader.beginArray();

        while(jsonReader.hasNext()) {
            sineList.add(getSine(jsonReader));
        }
        jsonReader.endArray();
        return sineList;
    }
    public  Sine getSine(JsonReader jsonReader) throws  IOException {
        String codPosto = "",nome = "",entidadeConveniada = "", uf="";
        jsonReader.beginObject();

        while (jsonReader.hasNext()){
            String obj = jsonReader.nextName();
            if (obj.equals("nome")){
                codPosto = jsonReader.nextString();
            }else if (obj.equals("nome")){
                nome = jsonReader.nextString();
            }else if (obj.equals("entidadeConvencionada")){
                entidadeConveniada = jsonReader.nextString();
            }else if (obj.equals("uf")) {
                uf = jsonReader.nextString();
            }else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new Sine(codPosto,nome,entidadeConveniada,uf);
    }
    @Override
    protected void onPostExecute(List<Sine> sines) {
        super.onPostExecute(sines);
    }
}
