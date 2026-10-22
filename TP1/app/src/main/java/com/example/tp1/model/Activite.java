package com.example.tp1.model;

public class Activite {

    private String date;
    private String titre;
    private String lieu;
    private boolean domicile;
    private int nombrePresences;

    public Activite(String date, String titre,
                    String lieu, boolean domicile) {
        this.date = date;
        this.titre = titre;
        this.lieu = lieu;
        this.domicile = domicile;
        this.nombrePresences = 0;
    }

    public String getDate() {
        return date;
    }

    public String getTitre() {
        return titre;
    }

    public String getLieu() {
        return lieu;
    }

    public boolean isDomicile() {
        return domicile;
    }

    public int getNombrePresences() {
        return nombrePresences;
    }

    public void ajouterPresence() {
        nombrePresences++;
    }

    @Override
    public String toString() {
        return titre;
    }
}
