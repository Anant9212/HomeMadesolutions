package com.example.anant.homemadesolutions;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.logging.LogRecord;

import static com.example.anant.homemadesolutions.R.anim.animation;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView text=(TextView)findViewById(R.id.txt);
        ImageView image=(ImageView)findViewById(R.id.img);
        Animation anim1= AnimationUtils.loadAnimation(this,R.anim.animation);
        text.setAnimation(anim1);
        image.setAnimation(anim1);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i;
                i=new Intent(splash.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },1500);

    }
}
