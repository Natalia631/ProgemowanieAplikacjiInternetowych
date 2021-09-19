package com.example.moshimoshi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private Button button;

    public static final String[] urls = {
            "https://paczaizm.pl/content/wp-content/uploads/porabalo-ta-facetke-50-szlaczkow-na-weekend-zadac.jpg",
            "https://img.besty.pl/images/398/69/3986946.jpg",
            "https://i.pinimg.com/474x/22/50/d0/2250d0104b25d5e8bde46c462822f291.jpg"
    };

    public static String getRandom(String[] array) {
        Random random = new Random();
        int randomNumber = random.nextInt(array.length);

        return array[randomNumber];
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LogOnResume", "ResumeLog");
        Log.d("random", getRandom(urls));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LogOnStop", "StopLog");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
    }


    public void onClick(View v) {
        String image = getRandom(urls);
        int index = Arrays.asList(urls).indexOf(image);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf(index));
        Glide.with(getApplicationContext()).load(image).into(imageView);
    }

    public void onClickActivity(View v) {
        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(intent);
    }

}