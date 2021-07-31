package net.androidsquad.volleyex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

  // private static String JSON_URL = "https://run.mocky.io/v3/f642d597-767d-4845-a2d8-c893249dfd50";
    //private static String JSON_URL = "https://dev-i10.pantheonsite.io/jsonapi/node/news";
//    879098927ffb4e8581416f5a079dab29
    private static String JSON_URL = "https://newsapi.org/v2/everything?q=Apple&from=2021-07-31&sortBy=popularity&apiKey=879098927ffb4e8581416f5a079dab29";

    String title, age;

    private ListView lv;

    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contactList = new ArrayList<>();
        lv = findViewById(R.id.listview);


        GetData getData = new GetData();
        getData.execute();

}


    public class GetData extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            // implement API in background and store the response in current variable
            String current = "";
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = urlConnection.getInputStream();
                    InputStreamReader isw = new InputStreamReader(in);
                    int data = isw.read();
                    while (data != -1) {
                        current += (char) data;
                        data = isw.read();
                        Log.v("current",current);
                        System.out.print(current);
                    }

                    return current;
                } catch (Exception e) {
                    Log.v("except",e.getMessage().toString());
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.v("except1",e.getMessage().toString());
                return "Exception: " + e.getMessage();
            }
            return current;
        }
        @Override
        protected void onPostExecute(String s) {


            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray1 = jsonObject.getJSONArray("articles");

                 for (int i =0 ; i< jsonArray1.length() ; i++) {
                     JSONObject jsonObject1 = jsonArray1.getJSONObject(i);
                     title = jsonObject1.getString("title");
                     age = jsonObject1.getString("title");
                     Log.v("data", title+age);

                     // tmp hash map for single contact
                     HashMap<String, String> contact = new HashMap<>();

                     // adding each child node to HashMap key => value
                     contact.put("name", title);
                     contact.put("age", age);

                     contactList.add(contact);
                 }

            } catch (JSONException e) {
                e.printStackTrace();
                Log.v("except2",e.getMessage().toString());
            }

            ListAdapter adapter = new SimpleAdapter(MainActivity.this, contactList,
                    R.layout.row_layout, new String[]{ "name","age"},
                    new int[]{R.id.textView, R.id.textView2});
            lv.setAdapter(adapter);
        }
    }
}

