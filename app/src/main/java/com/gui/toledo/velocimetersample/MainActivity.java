package com.gui.toledo.velocimetersample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private VelocimeterView velocimeterView;
    private Handler handler = new Handler(Looper.getMainLooper());
    private float simulatedSpeed = 0f;
    private final float speedIncrement = 5f;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        velocimeterView = new VelocimeterView(this);
        setContentView(velocimeterView);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                simulatedSpeed += speedIncrement;
                if (simulatedSpeed > 240) {
                    simulatedSpeed = 0f;
                }

                velocimeterView.setSpeed(simulatedSpeed);
                handler.postDelayed(this, 1000);
            }
        }, 1000);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}
