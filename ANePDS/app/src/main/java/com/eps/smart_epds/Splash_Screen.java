package com.eps.smart_epds;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.os.Handler;
import android.util.Log;

/**
 * Created by lenovo on 12/4/2017.
 */

public class Splash_Screen extends AppCompatActivity
{
    int SPLASH_DISPLAY_LENGTH = 4000;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        sleep();
      
    }

    private void sleep()
    {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {
            /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash_Screen.this,LoginActivity.class);
                Splash_Screen.this.startActivity(mainIntent);
                Splash_Screen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
