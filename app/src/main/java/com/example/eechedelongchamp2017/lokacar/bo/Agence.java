package com.example.eechedelongchamp2017.lokacar.bo;

import java.util.List;

public class Agence {

    private int id;
    private String nomAgence;
    private Adresse adresse;
    private Gerant gerant;
    private List<Voiture> parcVoiture;

    public Agence() {
    }

    public Agence(String nomAgence, Adresse adresse, Gerant gerant, List<Voiture> parcVoiture) {
        this.adresse = adresse;
        this.nomAgence = nomAgence;
        this.gerant = gerant;
        this.parcVoiture = parcVoiture;
    }

    public Agence(int id, String nomAgence, Adresse adresse, Gerant gerant, List<Voiture> parcVoiture) {
        this.id = id;
        this.adresse = adresse;
        this.nomAgence = nomAgence;
        this.gerant = gerant;
        this.parcVoiture = parcVoiture;
    }

    public int getId() {
        return id;
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

    public List<Voiture> getParcVoiture() {
        return parcVoiture;
    }

    public void setParcVoiture(List<Voiture> parcVoiture) {
        this.parcVoiture = parcVoiture;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "adresse=" + adresse +
                ", nomAgence='" + nomAgence + '\'' +
                ", gerant=" + gerant +
                ", parcVoiture=" + parcVoiture +
                '}';
    }
}
