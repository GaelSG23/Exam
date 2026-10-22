package com.example.tp1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.tp1.data.Donnees;
import com.example.tp1.model.Activite;
import com.example.tp1.model.Joueur;
import com.example.tp1.model.Presence;

public class Presences extends BaseActivity implements AdapterView.OnItemSelectedListener {
    RadioButton radioPresent;
    Joueur joueur;
    Activite activite;

    TextView text_activite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_presences);

        //Creation du button radio
        radioPresent = findViewById(R.id.radioPresent);

        TextView text_nbr = findViewById(R.id.textNbr);
        text_nbr.setText(String.valueOf(Donnees.getPresences().size()));

        text_activite = findViewById(R.id.activite);


        //Creation des spinners
        Spinner spinnerJoueur = findViewById(R.id.spinner_joueur);
        Spinner spinnerActivite = findViewById(R.id.spinner_activite);

        ArrayAdapter<Joueur> joueurAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                Donnees.getJoueurs()
        );

        joueurAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerJoueur.setAdapter(joueurAdapter);
        spinnerJoueur.setOnItemSelectedListener(this);



        ArrayAdapter<Activite> activiteAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                Donnees.getActivites()
        );

        activiteAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerActivite.setAdapter(activiteAdapter);
        spinnerActivite.setOnItemSelectedListener(this);

        radioPresent.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (joueur == null || activite == null)
                return;

            if (isChecked) {

                boolean exists = Donnees.getPresences().stream()
                        .anyMatch(p ->
                                p.getJoueur().equals(joueur) &&
                                        p.getActivite().equals(activite)
                        );

                if (!exists) {
                    Donnees.getPresences().add(
                            new Presence(joueur, activite, true)
                    );
                }

            } else {

                Donnees.getPresences().removeIf(p ->
                        p.getJoueur().equals(joueur) &&
                                p.getActivite().equals(activite)
                );
            }

            text_nbr.setText(
                    String.valueOf(Donnees.getPresences().size())
            );
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if (adapterView.getId() == R.id.spinner_joueur) {
            joueur = (Joueur) adapterView.getItemAtPosition(i);
        }

        if (adapterView.getId() == R.id.spinner_activite) {
            activite = (Activite) adapterView.getItemAtPosition(i);
            text_activite.setText(activite.getTitre());
        }

        // Only check once both have been selected
        if (joueur != null && activite != null) {

            boolean present = Donnees.getPresences().stream()
                    .anyMatch(p ->
                            p.getJoueur().equals(joueur) &&
                                    p.getActivite().equals(activite)
                    );

            radioPresent.setChecked(present);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}