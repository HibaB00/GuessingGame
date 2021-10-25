package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class noobLvl extends AppCompatActivity {

    ImageView image;
    ArrayList<String> imageName = new ArrayList<>();
    ArrayList<String> extraImages = new ArrayList<>();
    ArrayList<String> webImages = new ArrayList<>();
    ArrayList<String> altImg = new ArrayList<>();

    Pattern patterns;
    Matcher matcher;

    Random rand = new Random();
    int randImage = rand.nextInt(101);
    int randButton = rand.nextInt(4);

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    int turns = 0;
    TextView turnsText;

    public void buttonclick(View view) {
        Button button = (Button) view;
        if (turns < 10) {
            turns++;
            if (button.getText().equals(altImg.get(randImage))) {

                Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                randImage = rand.nextInt(101);
                button.setText(altImg.get(randImage));


                randButton = rand.nextInt(4);
                switch (randButton) {
                    case 0:
                        button.setText(altImg.get(randImage));
                        button2.setText(altImg.get(rand.nextInt(101)));
                        button3.setText(altImg.get(rand.nextInt(101)));
                        button4.setText(altImg.get(rand.nextInt(101)));
                        break;
                    case 1:
                        button2.setText(altImg.get(randImage));
                        button.setText(altImg.get(rand.nextInt(101)));
                        button3.setText(altImg.get(rand.nextInt(101)));
                        button4.setText(altImg.get(rand.nextInt(101)));
                        break;
                    case 2:
                        button3.setText(altImg.get(randImage));
                        button2.setText(altImg.get(rand.nextInt(101)));
                        button.setText(altImg.get(rand.nextInt(101)));
                        button4.setText(altImg.get(rand.nextInt(101)));
                        break;
                    case 3:
                        button4.setText(altImg.get(randImage));
                        button2.setText(altImg.get(rand.nextInt(101)));
                        button3.setText(altImg.get(rand.nextInt(101)));
                        button.setText(altImg.get(rand.nextInt(101)));
                        break;

                }
                image = (ImageView) findViewById(R.id.imageView);
                MainActivity.getImage task2 = new MainActivity.getImage();
                Bitmap downloadedImage;
                try {

                    downloadedImage = task2.execute(extraImages.get(randImage)).get();
                    image.setImageBitmap(downloadedImage);


                } catch (Exception e) {
                    e.printStackTrace();
                }


            } else {
                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();
            }
        } else {
            turnsText = (TextView) findViewById(R.id.turnstext);
            turnsText.setText("Play count ended!");
            button.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noob_lvl);
    }
}