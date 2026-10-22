package com.example.tp1.model;

public class Joueur {

    private String nom;
    private String prenom;
    private String courriel;
    private String telephone;

    public Joueur(String nom, String prenom,
                  String courriel, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }
}