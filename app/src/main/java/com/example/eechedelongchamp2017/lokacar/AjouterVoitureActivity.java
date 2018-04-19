package com.example.eechedelongchamp2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.eechedelongchamp2017.lokacar.adapter.TarifArrayAdapter;
import com.example.eechedelongchamp2017.lokacar.bo.Marque;
import com.example.eechedelongchamp2017.lokacar.bo.Tarif;
import com.example.eechedelongchamp2017.lokacar.bo.TypeLocatif;
import com.example.eechedelongchamp2017.lokacar.dal.MarqueDao;
import com.example.eechedelongchamp2017.lokacar.dal.TarifDao;
import com.example.eechedelongchamp2017.lokacar.dal.TypeLocatifDao;

import java.util.ArrayList;
import java.util.List;

public class AjouterVoitureActivity extends AppCompatActivity {

    private MarqueDao daoMarque;
    private TarifDao daoTarif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_voiture);

        // Init dao
        daoMarque = new MarqueDao(AjouterVoitureActivity.this);
        daoTarif = new TarifDao(AjouterVoitureActivity.this);

        // Bouton Home
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Ajouter une voiture");

        // Spinner nb de portes
        Spinner nb_portes_spinner = findViewById(R.id.nb_portes_spinner);
        String[] items = new String[]{"3 portes", "5 portes"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        nb_portes_spinner.setAdapter(adapter);

        // Spinner marques
        Spinner marques_spinner = findViewById(R.id.marques_spinner);
        List<Marque> marques = daoMarque.selectAll();
        List<String> marquesString = new ArrayList<>();
        for (Marque m : marques) {
            marquesString.add(m.getNom());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, marquesString);
        marques_spinner.setAdapter(adapter);

        // Spinner types locatif & prix
        Spinner typeLocatif_spinner = findViewById(R.id.tarifs_spinner);
        List<Tarif> tarifs = daoTarif.selectAll();

        for (Tarif t: tarifs) {
            Log.i("TAG", t.toString());
        }

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
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
