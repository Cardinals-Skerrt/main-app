package com.cardinalskerrt.appv2;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView startLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startLogo = findViewById(R.id.startLogo);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
        startLogo.startAnimation(fadeIn);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                goToIntent();
            }
        });
    }

    void goToIntent(){
        Intent intent = new Intent(this, UserScreen.class);
        startActivity(intent);
    }

}
