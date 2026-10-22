package com.example.tp1;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.ListView;
import com.example.tp1.adapter.JoueurAdapter;
import com.example.tp1.data.Donnees;
import com.example.tp1.model.Joueur;

public class Joueurs extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueurs);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Donnees.initialiser();
        ListView listViewJoueurs = findViewById(R.id.listViewJoueurs);
        JoueurAdapter adapter = new JoueurAdapter(
                this,
                Donnees.getJoueurs()
        );
        listViewJoueurs.setAdapter(adapter);
        listViewJoueurs.setOnItemClickListener(((parent, view, position, id) -> {
            Joueur joueurChoisi = Donnees.getJoueurs().get(position);

            new AlertDialog.Builder(this)
                    .setTitle(joueurChoisi.getPrenom() +"" + joueurChoisi.getNom())
                    .setMessage("Téléphone : " + joueurChoisi.getTelephone())
                    .setPositiveButton("OK", null)
                    .show();
        }));
    }
}