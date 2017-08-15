package com.example.gaby.adondevoy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by GABY on 21/5/2017.
 */

public class SplashScreenActivity extends AppCompatActivity {
    private ImageView ivLogo;
    private Animation animacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.splash_screen);

        ivLogo = (ImageView) findViewById(R.id.ivLogo);
        animacion = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion);
        ivLogo.startAnimation(animacion);

        animacion.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
