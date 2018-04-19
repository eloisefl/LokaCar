package com.example.eechedelongchamp2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AjouterVoitureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_voiture);

        // Bouton Home
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Ajouter une voiture");

        // Spinner nb de portes
        Spinner nb_portes_spinner = findViewById(R.id.nb_portes_spinner);
        String[] items = new String[]{"3 portes", "5 portes"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        nb_portes_spinner.setAdapter(adapter);

        // Spinner marques
        

        // Spinner types locatif & prix

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
