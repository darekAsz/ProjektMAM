package com.example.dasztemb.mamprojekt;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    private Sensor accSensor;
    private Sensor magneticSensor;
    private Sensor gravitySensor;
    private SensorManager sensorManager;

    private float[] acc;
    private float[] magnetic;
    private float[] gravity;

    TextView txtAccX;
    TextView txtAccY;
    TextView txtAccZ;
    TextView txtMagneticX;
    TextView txtMagneticY;
    TextView txtMagneticZ;
    TextView txtGravityX;
    TextView txtGravityY;
    TextView txtGravityZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        txtAccX = findViewById(R.id.txtAccelerationX);
        txtAccY = findViewById(R.id.txtAccelerationY);
        txtAccZ = findViewById(R.id.txtAccelerationZ);
        txtMagneticX = findViewById(R.id.txtMagneticX);
        txtMagneticY = findViewById(R.id.txtMagneticY);
        txtMagneticZ = findViewById(R.id.txtMagneticZ);
        txtGravityX = findViewById(R.id.txtGravityX);
        txtGravityY = findViewById(R.id.txtGravityY);
        txtGravityZ = findViewById(R.id.txtGravityZ);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magneticSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);

        if (accSensor == null) {
            txtAccY.setText(R.string.missing_sensor_acc);
            txtAccX.setText("");
            txtAccZ.setText("");
        }

        if (magneticSensor == null) {
            txtMagneticY.setText(R.string.missing_sensor_magnetic);
            txtMagneticX.setText("");
            txtMagneticZ.setText("");
        }


        if (gravitySensor == null) {
            txtGravityY.setText(R.string.missing_sensor_gravity);
            txtGravityX.setText("");
            txtGravityZ.setText("");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (accSensor != null)
            sensorManager.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_GAME);

        if (magneticSensor != null)
            sensorManager.registerListener(this, magneticSensor, SensorManager.SENSOR_DELAY_GAME);

        if (gravitySensor != null)
            sensorManager.registerListener(this, gravitySensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()) {
            case Sensor.TYPE_GRAVITY:
                gravity = event.values.clone();
                txtGravityX.setText("X: " + String.valueOf(gravity[0]));
                txtGravityY.setText("Y: " + String.valueOf(gravity[1]));
                txtGravityZ.setText("Z: " + String.valueOf(gravity[2]));
                break;
            case Sensor.TYPE_ACCELEROMETER:
                acc = event.values;
                txtAccX.setText("X: " + String.valueOf(acc[0]));
                txtAccY.setText("Y: " + String.valueOf(acc[1]));
                txtAccZ.setText("Z: " + String.valueOf(acc[2]));
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                magnetic = event.values;
                txtMagneticX.setText("X: " + String.valueOf(magnetic[0]));
                txtMagneticY.setText("Y: " + String.valueOf(magnetic[1]));
                txtMagneticZ.setText("Z: " + String.valueOf(magnetic[2]));
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
