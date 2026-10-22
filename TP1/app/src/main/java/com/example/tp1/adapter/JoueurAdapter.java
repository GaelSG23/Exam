package com.example.tp1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tp1.R;
import com.example.tp1.model.Joueur;

import java.util.ArrayList;

public class JoueurAdapter extends ArrayAdapter<Joueur> {

    public JoueurAdapter(Context context, ArrayList<Joueur> joueurs) {
        super(context, 0, joueurs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_joueur, parent, false);
        }

        Joueur joueur = getItem(position);

        TextView txtNom = convertView.findViewById(R.id.txtNomJoueur);
        TextView txtCourriel = convertView.findViewById(R.id.txtCourrielJoueur);

        if (joueur != null) {
            txtNom.setText(joueur.getPrenom() + " " + joueur.getNom());
            txtCourriel.setText(joueur.getCourriel());
        }

        return convertView;
    }
}