package com.example.athinodoros.lifecycleandtoast;

import android.app.Service;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Vibrator;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView textViewPath;
    private TextView textViewPath2;
    private SensorManager sensorManager;
    private Sensor lightSensor;
    private Vibrator vib;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "onCreate", Toast.LENGTH_SHORT).show();
        //Get ref to our resources:
        textViewPath = (TextView) findViewById(R.id.PathFinder);
        textViewPath2 = (TextView) findViewById(R.id.textView2);
        textViewPath.setText("Pelo is king!");

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //ask for access to magnetic sensor:
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        //Vibrator
        vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
//        if (getBaseContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){
//
//        }




    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "onStart", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "onResume", Toast.LENGTH_SHORT).show();
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_GAME);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "onPause", Toast.LENGTH_SHORT).show();
        sensorManager.unregisterListener(this, lightSensor);//
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "onStop", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "onDestroy", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "onRestart", Toast.LENGTH_SHORT).show();

    }

    public void buttonOnClickMagnet(View view){
        Toast.makeText(MainActivity.this, "Magnet clicked", Toast.LENGTH_SHORT).show();
        vib.vibrate(3000);
        Log.e("BLUE" , "I am in the button on click mangnet");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0]<40){

        }
        textViewPath2.setText(String.valueOf(event.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

//    @Override
//    public void onSensorChanged(SensorEvent event) {
//        if( event.sensor == lightSensor){
//            textViewPath2.setText((int) event.values[0]);
//        }
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//    }
}
