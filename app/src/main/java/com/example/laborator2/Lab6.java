package com.example.laborator2;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.laborator2.Listiner.Light;

import java.util.ArrayList;
import java.util.List;

public class Lab6 extends AppCompatActivity {

    private List<Product> list_sensors;
    public SensorManager mSensorManager;
    public Sensor mLight;
    public Light l;
    public Sensor mAccelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6);
        ListView listView = findViewById(R.id.list_sensors_2);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        list_sensors=new ArrayList<>();
        ArrayAdapter<Product> adapter = new ItemAdapter(this, list_sensors);
        listView.setAdapter(adapter);
        l=new Light(listView);

    }


    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(l, mLight, SensorManager.SENSOR_DELAY_NORMAL);
//        mSensorManager.registerListener(l, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(l);
    }
}
