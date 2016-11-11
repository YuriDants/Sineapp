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

public class ListarSinesAsyncTask extends AsyncTask <String, Void, List<Sine>>{
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Sine> doInBackground(String... strings){
        String urlString = strings[0];
        List<Sine> sine = new ArrayList<>();

        try {
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type","application/json");
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));

            sine = getSines(reader);
            inputStream.close();

        }   catch (IOException ex) {
            ex.printStackTrace();
            Log.e("Erro","Erro ao conectar a internet", ex);
        } finally {
            return  sine;
        }
    }




    public List<Sine> getSines(JsonReader reader) throws IOException {
        List<Sine> sineList = new ArrayList<>();
        reader.beginArray();

        while(reader.hasNext()) {
            sineList.add(getSine(reader));
        }
        reader.endArray();
        return sineList;
    }
    public  Sine getSine(JsonReader reader) throws  IOException {
        String codPosto = "",nome = "",entidadeConveniada = "", uf="";
       reader.beginObject();

        while (reader.hasNext()){
            String obj = reader.nextName();
            if (obj.equals("nome")){
                codPosto = reader.nextString();
            }else if (obj.equals("nome")){
                nome = reader.nextString();
            }else if (obj.equals("entidadeConvencionada")){
                entidadeConveniada = reader.nextString();
            }else if (obj.equals("uf")) {
                uf = reader.nextString();
            }else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Sine(codPosto,nome,entidadeConveniada,uf);
    }
    @Override
    protected void onPostExecute(List<Sine> sines) {
        super.onPostExecute(sines);
    }
}
