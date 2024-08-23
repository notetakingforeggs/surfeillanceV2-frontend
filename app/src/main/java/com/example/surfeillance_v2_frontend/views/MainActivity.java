package com.example.surfeillance_v2_frontend.views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.surfeillance_v2_frontend.R;

public class MainActivity extends AppCompatActivity {

    // rather than scheduling updates, check to see if timestamp of forecast data is x hours behind system time, and do api call if so each time new information is accessed?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}