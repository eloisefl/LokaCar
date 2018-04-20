package com.example.eechedelongchamp2017.lokacar.bo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Marque implements Parcelable {

    private int id;
    private String nom;
    private List<Voiture> voitures;
    private Modele modele;

    public Marque() {

    }

    public Marque(String nom) {
        this.nom = nom;
    }

    public Marque(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Marque(int id, String nom, List<Voiture> voitures, Modele modele) {
        this.id = id;
        this.nom = nom;
        this.voitures = voitures;
        this.modele = modele;
    }

    protected Marque(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        voitures = in.createTypedArrayList(Voiture.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeTypedList(voitures);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Marque> CREATOR = new Creator<Marque>() {
        @Override
        public Marque createFromParcel(Parcel in) {
            return new Marque(in);
        }

        @Override
        public Marque[] newArray(int size) {
            return new Marque[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    @Override
    public String toString() {
        return "Marque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", voitures=" + voitures +
                ", modele=" + modele +
                '}';
    }
}
