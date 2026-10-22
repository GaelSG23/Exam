package com.example.f_s5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnChange = findViewById(R.id.btnClick);

        btnChange.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MapsFragment.class);
            startActivity(intent);
        });
    }

}