package net.androidsquad.moviejson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // We will build a professional app ;)


    // Link for popular movies https://api.themoviedb.org/3/movie/popular?api_key=52a18783ed514602a5facb15a0177e61
   // private static String JSON_URL = "https://api.themoviedb.org/3/movie/popular?api_key=52a18783ed514602a5facb15a0177e61";
    private static String JSON_URL = "https://dev-i10.pantheonsite.io/jsonapi/node/news";


    List<MovieModelClass> movieList;
    RecyclerView recyclerView;
    ImageView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        header  = findViewById(R.id.imageView2);

        Glide.with(this)
                .load(R.drawable.header)
                .into(header);



        GetData getData = new GetData();
        getData.execute();
    }


    public class GetData extends AsyncTask<String, String, String>{


        @Override
        protected String doInBackground(String... strings) {

            String current= "";

            try{
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();


                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while(data != -1){
                        current += (char) data;
                        data = isr.read();

                    }
                    return current;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(urlConnection != null){
                        urlConnection.disconnect();
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


            return current;
        }


        @Override
        protected void onPostExecute(String s) {

            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray   = jsonObject.getJSONArray("data");

                for (int i = 0 ; i< jsonArray.length() ; i++){

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);


                    MovieModelClass model = new MovieModelClass();
                    model.setId(jsonObject1.getString("type"));
                    model.setName(jsonObject1.getString("type"));
                    model.setImg(jsonObject1.getString("type"));
                    Log.v("vote_average",jsonObject1.getString("type"));

                    movieList.add(model);

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            PutDataIntoRecyclerView( movieList);

        }
    }

    private void PutDataIntoRecyclerView(List<MovieModelClass> movieList){

        Adaptery adaptery = new Adaptery(this, movieList);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        recyclerView.setAdapter(adaptery);
    }



}

// Amazing !!!!!
// Now let's work on UI and Layouts