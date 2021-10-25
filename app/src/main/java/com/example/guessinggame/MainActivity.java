package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    public void getDifficulty(View view){
        Button button = (Button) view;
        int id = button.getId();
        if (id == findViewById(R.id.noobLvl).getId()) {
            Intent intent = new Intent(MainActivity.this, noobLvl.class);
            startActivity(intent);
        }
        if (id == findViewById(R.id.botLvl).getId()) {
            Intent intent = new Intent(MainActivity.this, botLvl.class);
            startActivity(intent);
        }
        if (id == findViewById(R.id.legendLvl).getId()) {
            Intent intent = new Intent(MainActivity.this, legendLvl.class);
            startActivity(intent);
        }
    }

    public static class getImage extends AsyncTask<String, Void, Bitmap> {
        protected Bitmap doInBackground(String... urls) {

            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream in = connection.getInputStream();

                Bitmap DownloadedImage = BitmapFactory.decodeStream(in);

                return DownloadedImage;


            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }


        }
    }



    public static class fetchURL extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... strings) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(reader);
                String line;

                while ((line = br.readLine()) != null) {
                    result += line;

                }

                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return "Failed";
            }
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}