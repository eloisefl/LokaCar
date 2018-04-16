package com.example.eechedelongchamp2017.lokacar.bo;

import java.util.List;

public class Agence {

    private Adresse adresse;
    private String nomAgence;
    private Gerant gerant;
    private List<Voiture> parcAgence;

    public Agence() {
    }

    public Agence(Adresse adresse, String nomAgence, Gerant gerant, List<Voiture> parcAgence) {
        this.adresse = adresse;
        this.nomAgence = nomAgence;
        this.gerant = gerant;
        this.parcAgence = parcAgence;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public Gerant getGerant() {
        return gerant;
    }

    public void setGerant(Gerant gerant) {
        this.gerant = gerant;
    }

    public List<Voiture> getParcAgence() {
        return parcAgence;
    }

    public void setParcAgence(List<Voiture> parcAgence) {
        this.parcAgence = parcAgence;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "adresse=" + adresse +
                ", nomAgence='" + nomAgence + '\'' +
                ", gerant=" + gerant +
                ", parcAgence=" + parcAgence +
                '}';
    }

}
