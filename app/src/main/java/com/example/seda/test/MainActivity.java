package com.example.seda.test;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res = getResources();
                Drawable drawable = res.getDrawable(R.drawable.circular);
                ProgressBar mProgress = (ProgressBar) findViewById(R.id.circularProgressbar);
                mProgress.setProgress(0);   // Main Progress
                //mProgress.setSecondaryProgress(50); // Secondary Progress
                mProgress.setMax(100); // Maximum Progress
                mProgress.setProgressDrawable(drawable);

                ObjectAnimator animation = new ObjectAnimator();

                for(int count = 0; count <= 100; count+=5) {
                    progress = count;
                     animation = ObjectAnimator.ofInt(mProgress, "progress", 0, count);

                    animation.setDuration(1500);

                    animation.setInterpolator(new LinearInterpolator());

                    animation.start();
                }
                animation.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        if(progress >= 100) {
                            Toast.makeText(MainActivity.this, "Load completed", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });

            }

        });


        Button tooltipButton = (Button) findViewById(R.id.tooltip_button);
        tooltipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TooltipActivity.class);
                startActivity(intent);

            }
        });

    }
}
