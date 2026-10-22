package com.example.tp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp1.data.Donnees;

public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Donnees.initialiser();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_joueurs) {
            startActivity(new Intent(this, Joueurs.class));
            return true;
        }

        if (item.getItemId() == R.id.action_calendrier) {
            startActivity(new Intent(this, Calendrier.class));
            return true;
        }

        if (item.getItemId() == R.id.action_presences) {
            startActivity(new Intent(this, Presences.class));
            return true;
        }

        if (item.getItemId() == R.id.action_nos_partenaires) {
            startActivity(new Intent(this, Partenaires.class));
            return true;
        }

        if (item.getItemId() == R.id.action_sondage) {
            startActivity(new Intent(this, Sondage.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}