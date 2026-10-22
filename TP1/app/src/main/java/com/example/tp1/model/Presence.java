package com.example.tp1.model;

public class Presence {

    private Joueur joueur;
    private Activite activite;
    private boolean present;

    public Presence(Joueur joueur, Activite activite, boolean present) {
        this.joueur = joueur;
        this.activite = activite;
        this.present = present;
    }

    // getters...

    public Joueur getJoueur() {
        return joueur;
    }

    public Activite getActivite() {
        return activite;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}