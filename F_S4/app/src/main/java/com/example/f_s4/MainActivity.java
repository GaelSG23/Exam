package com.example.f_s4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs =
                PreferenceManager.getDefaultSharedPreferences(this);

        Button BntAjouterPreferences = findViewById(R.id.AjouterPreferences);
        Button BntAfficherPreferences = findViewById(R.id.AfficherPreferences);

        TextView password = findViewById(R.id.password);
        TextView nom = findViewById(R.id.nom);
        TextView checkBox = findViewById(R.id.checkBox);
        TextView listpref = findViewById(R.id.listpref);


        BntAjouterPreferences.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,
                    PreferencesActivity.class);
            startActivity(intent);
        });

        BntAfficherPreferences.setOnClickListener(v -> {
            password.setText(prefs.getString("nom", ""));
            nom.setText(prefs.getString("password", ""));

            boolean checkBox_b = prefs.getBoolean("checkBox", true);
            checkBox.setText(String.valueOf(checkBox_b));

            listpref.setText(prefs.getString("listpref", ""));
        });
    }
}