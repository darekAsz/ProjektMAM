package com.example.dasztemb.mamprojekt;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout btnSensors;
    private LinearLayout btnCamera;
    private LinearLayout btnSplitScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSensors = (LinearLayout) findViewById(R.id.layoutSensors);
        btnCamera = (LinearLayout) findViewById(R.id.layoutCamera);
        btnSplitScreen = (LinearLayout) findViewById(R.id.layoutVR);

        btnSensors.setOnClickListener(btnClickListener);
        btnCamera.setOnClickListener(btnClickListener);
        btnSplitScreen.setOnClickListener(btnClickListener);

    }

    private RelativeLayout.OnClickListener btnClickListener = v -> {
        Intent intent;

        switch (v.getId()) {

            case R.id.layoutSensors:
                intent = new Intent(this, SensorActivity.class);
                startActivity(intent);
                break;
            case R.id.layoutCamera:
                intent = new Intent(this, GooglyEyesActivity.class);
                startActivity(intent);
                break;
            case R.id.layoutVR:
                intent = new Intent(this, SplitScreenActivity.class);
                startActivity(intent);
                break;
        }
    };
}
