package com.example.f_s4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content,
                        new PreferencesFragment())
                .commit();
    }

    public static class PreferencesFragment
            extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(
                Bundle savedInstanceState,
                String rootKey) {

            setPreferencesFromResource(
                    R.xml.preferences,
                    rootKey
            );
        }
    }
}