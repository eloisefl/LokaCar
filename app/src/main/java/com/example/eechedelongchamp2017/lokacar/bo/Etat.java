package com.example.eechedelongchamp2017.lokacar.bo;

import java.util.Date;

public class Etat {

    private int id;
    private Date dateEtat;
    private String description;
    private Location location;

    public Etat() {

    }

    public Etat(int id, Date dateEtat, String description, Location location) {
        this.id = id;
        this.dateEtat = dateEtat;
        this.description = description;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateEtat() {
        return dateEtat;
    }

    public void setDateEtat(Date dateEtat) {
        this.dateEtat = dateEtat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Etat{" +
                "id=" + id +
                ", dateEtat=" + dateEtat +
                ", description='" + description + '\'' +
                ", location=" + location +
                '}';
    }
}
