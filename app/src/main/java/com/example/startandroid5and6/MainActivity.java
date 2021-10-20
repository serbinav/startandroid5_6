package com.example.startandroid5and6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView showSecret = findViewById(R.id.name);
        FrameLayout secretLayout = findViewById(R.id.loading_layout);
        Button hideSecret = findViewById(R.id.secret);

        showSecret.setOnClickListener(view ->
                secretLayout.setVisibility(View.VISIBLE)
        );

        hideSecret.setOnClickListener(view ->
                secretLayout.setVisibility(View.GONE)
        );
    }
}