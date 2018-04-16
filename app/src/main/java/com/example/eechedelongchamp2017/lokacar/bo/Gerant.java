package com.example.eechedelongchamp2017.lokacar.bo;

public class Gerant extends Personne {

    private int id;
    private String login;
    private String mdp;

    public Gerant() {
    }

    public Gerant(int id, String login, String mdp) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Gerant{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
