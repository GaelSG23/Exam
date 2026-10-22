package com.example.tp1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Sondage extends BaseActivity {

    private double sommeNotes = 0;
    private int nombreNotes = 0;

    private static final String NOM_FICHIER = "sondage.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sondage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText editNom = findViewById(R.id.editNom);
        EditText editNote = findViewById(R.id.editNote);
        EditText editCommentaire = findViewById(R.id.editCommentaire);

        Button btnEnvoyer = findViewById(R.id.btnEnvoyer);

        TextView txtMoyenne = findViewById(R.id.textMoyenne);

        chargerDonnees();

        if (nombreNotes > 0) {
            double moyenne = sommeNotes / nombreNotes;
            txtMoyenne.setText(String.format("Moyenne : %s", moyenne));
        }

        btnEnvoyer.setOnClickListener(v -> {

            String nom = editNom.getText().toString();
            String noteTexte = editNote.getText().toString();
            String commentaire = editCommentaire.getText().toString();

            if (noteTexte.isEmpty()) {
                Toast.makeText(
                        this,
                        "entrez une note svp.",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            double note = Double.parseDouble(noteTexte);
            if (note < 0 || note > 10) {
                Toast.makeText(
                        this,
                        "Le nombre doit être entre 0 et 10.",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }
            sommeNotes += note;
            nombreNotes++;
            double moyenne = sommeNotes / nombreNotes;
            txtMoyenne.setText(String.format("Moyenne : %s", moyenne));
            sauvegarde();
        });
    }

    private void sauvegarde() {

        String donnees = sommeNotes + ";" + nombreNotes;

        try {
            FileOutputStream fichier =
                    openFileOutput(NOM_FICHIER, MODE_PRIVATE);

            fichier.write(donnees.getBytes());
            fichier.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void chargerDonnees() {

        try {
            FileInputStream fichier = openFileInput(NOM_FICHIER);

            byte[] contenu = new byte[fichier.available()];
            fichier.read(contenu);
            fichier.close();

            String donnees = new String(contenu);

            String[] valeurs = donnees.split(";");

            String somme = valeurs[0];
            String nombre = valeurs[1];

            sommeNotes = Double.parseDouble(somme);
            nombreNotes = Integer.parseInt(nombre);

        } catch (IOException e) {
            sommeNotes = 0;
            nombreNotes = 0;
        }
    }
}