package com.example.eechedelongchamp2017.lokacar.bo;

import java.util.List;

public class Conducteur extends Personne {

    private int id;
    private String numPermis;
    private List<Location> locations;

    public Conducteur() {

    }

    public Conducteur(int id, String numPermis, List<Location> locations) {
        this.id = id;
        this.numPermis = numPermis;
        this.locations = locations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumPermis() {
        return numPermis;
    }

    public void setNumPermis(String numPermis) {
        this.numPermis = numPermis;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Conducteur{" +
                "id=" + id +
                ", numPermis='" + numPermis + '\'' +
                ", locations=" + locations +
                '}';
    }
}
