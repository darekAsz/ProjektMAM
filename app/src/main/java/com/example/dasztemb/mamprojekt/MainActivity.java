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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSensors = (LinearLayout) findViewById(R.id.layoutSensors);
        btnCamera = (LinearLayout) findViewById(R.id.layoutCamera);

        btnSensors.setOnClickListener(btnClickListener);
        btnCamera.setOnClickListener(btnClickListener);

    }

    private RelativeLayout.OnClickListener btnClickListener = v -> {
        switch (v.getId()) {

            case R.id.layoutSensors:
                Intent intent = new Intent(this, SensorActivity.class);
                startActivity(intent);
                break;
            case R.id.layoutCamera:
                break;
            case R.id.layoutVR:
                break;
        }
    };
}
