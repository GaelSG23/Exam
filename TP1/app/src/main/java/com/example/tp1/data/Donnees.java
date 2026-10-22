package com.example.tp1.data;

import com.example.tp1.model.Activite;
import com.example.tp1.model.Joueur;
import com.example.tp1.model.Presence;

import java.util.ArrayList;

public class Donnees {

    public static ArrayList<Joueur> joueurs = new ArrayList<>();
    public static ArrayList<Activite> activites = new ArrayList<>();
    public static ArrayList<Presence> presences = new ArrayList<>();
    public static void initialiser() {

        if (!joueurs.isEmpty()) {
            return;
        }

        joueurs.add(new Joueur(
                "Jeromme",
                "Ouellet",
                "jerome.oeul@icloud.com",
                "581-443-3625"
        ));

        joueurs.add(new Joueur(
                "Dupont",
                "Thierry",
                "thierry.dupont@gmail.com",
                "418-555-1234"
        ));

        joueurs.add(new Joueur(
                "Tremblay",
                "Alex",
                "alex.tremblay@gmail.com",
                "418-555-9012"
        ));

        activites.add(new Activite(
                "2026-09-25",
                "Pratique #1",
                "Cégep Limoilou",
                true
        ));

        activites.add(new Activite(

                "2026-09-27",
                "Pratique #2",
                "Cégep Limoilou",
                true
        ));

        activites.add(new Activite(
                "2026-09-30",
                "Match vs Caravelles",
                "Collège de Lévis",
                false
        ));

        activites.add(new Activite(
                "2026-07-30",
                "Match vs Titans",
                "Cégep Limoilou",
                true
        ));

    }

    public static ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public static ArrayList<Activite> getActivites() {
        return activites;
    }

    public static ArrayList<Presence> getPresences() {
        return presences;
    }
}
