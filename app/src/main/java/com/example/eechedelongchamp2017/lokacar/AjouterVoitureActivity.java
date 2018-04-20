package com.example.eechedelongchamp2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.eechedelongchamp2017.lokacar.adapter.TarifArrayAdapter;
import com.example.eechedelongchamp2017.lokacar.bo.Agence;
import com.example.eechedelongchamp2017.lokacar.bo.DataContract;
import com.example.eechedelongchamp2017.lokacar.bo.Location;
import com.example.eechedelongchamp2017.lokacar.bo.Marque;
import com.example.eechedelongchamp2017.lokacar.bo.Modele;
import com.example.eechedelongchamp2017.lokacar.bo.Tarif;
import com.example.eechedelongchamp2017.lokacar.bo.TypeLocatif;
import com.example.eechedelongchamp2017.lokacar.bo.Voiture;
import com.example.eechedelongchamp2017.lokacar.dal.MarqueDao;
import com.example.eechedelongchamp2017.lokacar.dal.ModeleDao;
import com.example.eechedelongchamp2017.lokacar.dal.TarifDao;
import com.example.eechedelongchamp2017.lokacar.dal.TypeLocatifDao;
import com.example.eechedelongchamp2017.lokacar.dal.VoitureDao;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class AjouterVoitureActivity extends AppCompatActivity {

    private MarqueDao daoMarque;
    private TarifDao daoTarif;
    private VoitureDao daoVoiture;
    private ModeleDao daoModel;

    private String LOG_TAG = "TAG_LOKACAR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_voiture);

        // Init dao
        daoMarque = new MarqueDao(AjouterVoitureActivity.this);
        daoTarif = new TarifDao(AjouterVoitureActivity.this);
        daoModel = new ModeleDao(AjouterVoitureActivity.this);

        // Bouton Home
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Ajouter une voiture");

        // Spinner nb de portes
        Spinner nb_portes_spinner = findViewById(R.id.voiture_nb_portes);
        String[] items = new String[]{"3 portes", "5 portes"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        nb_portes_spinner.setAdapter(adapter);

        // Spinner marques
        Spinner marques_spinner = findViewById(R.id.voiture_marque);
        List<Marque> marques = daoMarque.selectAll();
        List<String> marquesString = new ArrayList<>();
        for (Marque m : marques) {

            Log.i(LOG_TAG, m.toString());
            List<Modele> modeles = daoModel.selectAllByMarque(m.getId());
            for (Modele mod : modeles) {
                Log.i(LOG_TAG, mod.toString());
                marquesString.add(m.getNom()+ " " + mod.getNom());
            }

            // marquesString.add(m.getNom());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, marquesString);
        marques_spinner.setAdapter(adapter);

        // Spinner types locatif & prix
        Spinner typeLocatif_spinner = findViewById(R.id.voiture_tarifs);
        List<Tarif> tarifs = daoTarif.selectAll();
        TarifArrayAdapter adapterTarif = new TarifArrayAdapter(this, R.layout.tarif_adapter_layout, R.id.spinnerprix_prix, tarifs);
        typeLocatif_spinner.setAdapter(adapterTarif);

    }

    // Ajout du menu principal
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(AjouterVoitureActivity.this);
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Selection des items du menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {

            case android.R.id.home:
                intent = new Intent(AjouterVoitureActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.mes_voitures:
                intent = new Intent(AjouterVoitureActivity.this, MesVoituresActivity.class);
                startActivity(intent);
                break;

            case R.id.deconnexion:
                intent = new Intent(AjouterVoitureActivity.this, AuthActivity.class);
                startActivity(intent);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void cancelVoitureFormClick(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void validateVoitureFormClick(View view) {

        /*

        TextView immatriculationsTxtV = findViewById(R.id.voiture_immatriculations);
        String immatriculations = immatriculationsTxtV.getText().toString();
        String[] immatriculation = immatriculations.split(",");

        Spinner voiture_nb_portes = findViewById(R.id.voiture_nb_portes);
        // int nbPortes = voiture_nb_portes.getSelectedItem().toString();
        Log.i("NbPortesSpinner", voiture_nb_portes.getSelectedItem().toString());

        /*
        Spinner voiture_nb_places = findViewById(R.id.voiture_);
        // int nbPlaces = voiture_nb_portes.getSelectedItem().toString();
        Log.i("NbPlacesSpinner", voiture_nb_places.getSelectedItem().toString());


        TextView voiture_puissanceMoteur = findViewById(R.id.voiture_puissanceMoteur);
        int puissanceMoteur = Integer.parseInt(voiture_puissanceMoteur.getText().toString());

        boolean isEssence = false, isDiesel = false;
        RadioButton ck_essence = findViewById(R.id.ck_essence);
        RadioButton ck_diesel = findViewById(R.id.ck_diesel);
        if (ck_essence.isSelected()) {
            isEssence = true;
        }
        if (ck_diesel.isSelected()) {
            isDiesel = true;
        }

        int nbPortes = 0;

        // TextView nb_places = findViewById(R.id.nb_portes_spinner);
        int nbPlaces = 0;

        boolean isLoue = false;

        boolean isDisponible = true;
        RadioButton ck_non_dispo_location = findViewById(R.id.ck_non_dispo_location);
        if (ck_non_dispo_location.isSelected()) {
            isDisponible = false;
        }

        Spinner marques_spinner = (Spinner) findViewById(R.id.voiture_marque);
        Marque marque = null;

        TypeLocatif typeLocatif = null;
        Agence agence = null;

        String photoNom = null;
        Blob photoContent = null;
        List<Location> locations = null;

        for (int i=0; i<immatriculation.length; i++) {
            Log.i("TAG", new Voiture(immatriculation[i], nbPortes, nbPlaces, isEssence, isDiesel, puissanceMoteur, marque,
                    isLoue, isDisponible, photoNom, photoContent, typeLocatif, locations, agence).toString());
        }
*/
        // daoVoiture.insert(new Voiture(immatriculation, nbPortes, nbPlaces, isEssence, isDiesel, puissanceMoteur, marque,
                // isLoue, isDisponible, photoNom, photoContent, typeLocatif, locations, agence));
    }
}
