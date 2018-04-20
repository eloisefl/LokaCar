package com.example.eechedelongchamp2017.lokacar.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Modele implements Parcelable {

    private int id;
    private String nom;
    private Marque marque;

    public Modele() {

    }

    public Modele(String nom, Marque marque) {
        this.nom = nom;
        this.marque = marque;
    }

    public Modele(int id, String nom, Marque marque) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
    }

    protected Modele(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        marque = in.readParcelable(Marque.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeParcelable(marque, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Modele> CREATOR = new Creator<Modele>() {
        @Override
        public Modele createFromParcel(Parcel in) {
            return new Modele(in);
        }

        @Override
        public Modele[] newArray(int size) {
            return new Modele[size];
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

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Modele{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", marque=" + marque +
                '}';
    }
}
