package com.example.eechedelongchamp2017.lokacar;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.eechedelongchamp2017.lokacar.adapter.MesVoituresGenreAdapter;
import com.example.eechedelongchamp2017.lokacar.bo.Marque;
import com.example.eechedelongchamp2017.lokacar.bo.Modele;
import com.example.eechedelongchamp2017.lokacar.bo.Voiture;
import com.example.eechedelongchamp2017.lokacar.fragments.ListeVoitureGenreFragment;
import com.example.eechedelongchamp2017.lokacar.fragments.MesVoitureGenreFragment;

import java.util.ArrayList;
import java.util.List;

public class MesVoituresGenreActivity extends AppCompatActivity
    // implements ListeVoitureGenreFragment.OnListFragmentInteractionListener
        implements MesVoitureGenreFragment.OnFragmentInteractionListener
{

    private ListView listview_voituresgenres;
    private MesVoituresGenreAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_voitures_genre);

        // Données de la ListView
        List<Voiture> list = new ArrayList<>();
        Voiture voit = new Voiture();
        voit.setImmatriculation("IFKHSNCH5421SKDN");
        voit.setMarque(new Marque(1, "citroen", new ArrayList<Voiture>(), new Modele(1, "c3", null)));
        list.add(voit);
        list.add(voit);
        list.add(voit);

        // ListView
        listview_voituresgenres = (ListView) findViewById(R.id.listview_voituresgenres);
        adapter = new MesVoituresGenreAdapter(MesVoituresGenreActivity.this, R.layout.fragment_mes_voiture_genre_content, list);
        listview_voituresgenres.setAdapter(adapter);



    }

    // Implementation Fragment
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    // Ajout du menu principal
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(MesVoituresGenreActivity.this);
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Selection des items du menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.mes_voitures:
                Intent intent = new Intent(MesVoituresGenreActivity.this, MesVoituresActivity.class);
                startActivity(intent);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
