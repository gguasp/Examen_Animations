package com.example.examenanimations;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Posta de Sol");

        final FrameLayout sky = findViewById(R.id.sky);
        final ImageView sun = findViewById(R.id.sun);

        final int color1 = Color.BLUE;
        final int color2 = Color.GRAY;
        final int color3 = Color.YELLOW;
        final int color4 = Color.BLACK;

        sky.setOnClickListener(new View.OnClickListener() {

                int limit = sky.getHeight();

                ObjectAnimator animY = ObjectAnimator.ofFloat(sun, "y", limit);
                animY.setDuration(3000);
                AnimatorSet animSetXY = new AnimatorSet();

                ObjectAnimator animSky1 = ObjectAnimator.ofObject(sky, "backgroundColor", new ArgbEvaluator(), color1, color2).setDuration(300);
                ObjectAnimator animSky2 = ObjectAnimator.ofObject(sky, "backgroundColor", new ArgbEvaluator(), color2, color3).setDuration(300);
                ObjectAnimator animSky3 = ObjectAnimator.ofObject(sky, "backgroundColor", new ArgbEvaluator(), color3, color4).setDuration(300);

                animSetXY.playTogether(animSky1, animY);
                animSetXY.start();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}